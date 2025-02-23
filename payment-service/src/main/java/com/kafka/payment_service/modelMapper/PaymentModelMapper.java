package com.kafka.payment_service.modelMapper;

import com.kafka.payment_service.dto.PaymentDto;
import com.kafka.payment_service.entity.Payment;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentModelMapper {

    private final ModelMapper mapper;

    public Payment map_PaymentDto_Payment(PaymentDto paymentDto){
        return mapper.map(paymentDto, Payment.class);
    }

    public PaymentDto map_Payment_PaymentDto(Payment payment){
        return mapper.map(payment, PaymentDto.class);
    }

}
