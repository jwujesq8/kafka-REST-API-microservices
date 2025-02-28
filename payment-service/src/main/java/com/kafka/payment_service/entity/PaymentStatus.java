package com.kafka.payment_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.util.UUID;

@Entity
@Table(name = "payment_status")
@Getter
public class PaymentStatus {

    @Id
    private int Integer;
    private String status;
}
