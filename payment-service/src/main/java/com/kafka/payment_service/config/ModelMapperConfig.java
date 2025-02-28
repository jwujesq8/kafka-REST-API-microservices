package com.kafka.payment_service.config;

import com.kafka.order_service.entity.OrderId;
import com.kafka.order_service.entity.OrderStatus;
import com.kafka.payment_service.dto.PaymentDto;
import com.kafka.payment_service.entity.Payment;
import com.kafka.payment_service.entity.PaymentId;
import com.kafka.payment_service.entity.PaymentStatus;
import com.kafka.payment_service.repository.PaymentRepository;
import com.kafka.payment_service.repository.PaymentStatusRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
@RequiredArgsConstructor
public class ModelMapperConfig {
    private final PaymentStatusRepository paymentStatusRepository;

    @Bean
    public ModelMapper modelMapper(){

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setImplicitMappingEnabled(false);

        // CONVERTORS
                // String -> PaymentStatus
                Converter<String, PaymentStatus> converter_StatusString_PaymentStatus = statusString ->
                        paymentStatusRepository.findByStatus(statusString.getSource());

                // OrderStatus -> String
                Converter<PaymentStatus, String> converter_PaymentStatus_StatusString = paymentStatus ->
                        paymentStatus.getSource().getStatus();

                // Payment -> UUID
                Converter<PaymentId, UUID> converter_PaymentId_UserId = paymentId -> paymentId.getSource().getUserId();
                Converter<PaymentId, UUID> converter_PaymentId_OrderId = paymentId -> paymentId.getSource().getOrderId();

        // PaymentDto->Payment
        // + UUID userId, UUID orderId -> PaymentId
        // + String status -> PaymentStatus
        TypeMap<PaymentDto, Payment> typeMap_PaymentDto_Payment = mapper.createTypeMap(PaymentDto.class, Payment.class);
        typeMap_PaymentDto_Payment.addMappings(mapping -> mapping.skip(Payment::setId));
        typeMap_PaymentDto_Payment.addMappings(mapping -> mapping
                .using(converter_StatusString_PaymentStatus)
                .map(PaymentDto::getStatus, Payment::setPaymentStatus));
        typeMap_PaymentDto_Payment.setPostConverter(context -> {
            PaymentDto source = context.getSource();
            Payment destination = context.getDestination();
            PaymentId paymentId = new PaymentId(source.getUserId(), source.getOrderId());
            destination.setId(paymentId);
            return destination;
        });
        typeMap_PaymentDto_Payment.implicitMappings();



        // Payment->PaymentDto
        // + PaymentId -> UUID userId, UUID orderId
        // + PaymentStatus -> String status
        TypeMap<Payment, PaymentDto> typeMap_Payment_PaymentDto = mapper.createTypeMap(Payment.class, PaymentDto.class);
        typeMap_Payment_PaymentDto.addMappings(mapping -> mapping
                .using(converter_PaymentId_UserId)
                .map(Payment::getId, PaymentDto::setUserId));
        typeMap_Payment_PaymentDto.addMappings(mapping -> mapping
                .using(converter_PaymentId_OrderId)
                .map(Payment::getId, PaymentDto::setOrderId));
        typeMap_Payment_PaymentDto.addMappings(mapping -> mapping
                .using(converter_PaymentStatus_StatusString)
                .map(Payment::getPaymentStatus, PaymentDto::setStatus));

        return mapper;

    }
}
