package com.kafka.payment_service.repository;

import com.kafka.payment_service.entity.Payment;
import com.kafka.payment_service.entity.PaymentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, PaymentId> {
}