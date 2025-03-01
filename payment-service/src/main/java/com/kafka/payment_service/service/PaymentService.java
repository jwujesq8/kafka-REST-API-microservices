package com.kafka.payment_service.service;

import com.kafka.payment_service.dto.PaymentDto;
import com.kafka.payment_service.entity.PaymentId;
import org.hibernate.validator.internal.constraintvalidators.bv.time.past.PastValidatorForYear;

import java.util.Optional;

public interface PaymentService {

    public PaymentDto addPayment(PaymentDto paymentDto);
    public PaymentDto updatePayment(PaymentDto paymentDto);
    public Optional<PaymentDto> getPayment(PaymentId paymentId);
    public void deletePayment(PaymentId paymentId);

    // kafka consumer
    public void makePayment(PaymentId paymentId);

    // kafka producer
    public void sendPaymentStatusInfo(PaymentId paymentId);


}