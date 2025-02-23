package com.kafka.payment_service.entity;

import com.kafka.order_service.entity.Order;
import com.kafka.user_service.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity()
@Table(name = "payments")
@Setter
@Getter
public class Payment {

    @EmbeddedId
    private PaymentId id;

    private Date date;
    private float price;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private PaymentStatus paymentStatus;

    @Transient
    private User user;
    @Transient
    private Order order;

}
