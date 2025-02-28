package com.kafka.payment_service.repository;

import com.kafka.payment_service.entity.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentStatusRepository extends JpaRepository<PaymentStatus, Integer> {

    public PaymentStatus findByStatus(String status);
}
