package com.kafka.payment_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "payment_status")
public class PaymentStatus {

    @Id
    private int id;
    private String status;
}
