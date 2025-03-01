package com.kafka.payment_service.service;

import com.kafka.payment_service.dto.PaymentDto;
import com.kafka.payment_service.entity.Payment;
import com.kafka.payment_service.entity.PaymentId;
import com.kafka.payment_service.modelMapper.PaymentModelMapper;
import com.kafka.payment_service.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentModelMapper paymentModelMapper;

    public PaymentDto addPayment(PaymentDto paymentDto) {
        Payment payment = paymentModelMapper.map_PaymentDto_Payment(paymentDto);
        payment.setDate(Date.from(Instant.now()));
        paymentRepository.save(payment);
        return paymentModelMapper.map_Payment_PaymentDto(payment);
    }

    public PaymentDto updatePayment(PaymentDto paymentDto) {
        Payment payment = paymentModelMapper.map_PaymentDto_Payment(paymentDto);
        return paymentModelMapper.map_Payment_PaymentDto(paymentRepository.save(payment));
    }

    public Optional<PaymentDto> getPayment(PaymentId paymentId) {
        Payment payment = paymentRepository.findById(paymentId).orElse(null);
        return Optional.of(paymentModelMapper.map_Payment_PaymentDto(payment));
    }

    public void deletePayment(PaymentId paymentId) {

    }

    // TODO: kafka consumer
    public void makePayment(PaymentId paymentId) {

    }

    // TODO: kafka producer
    public void sendPaymentStatusInfo(PaymentId paymentId){

    }
}
