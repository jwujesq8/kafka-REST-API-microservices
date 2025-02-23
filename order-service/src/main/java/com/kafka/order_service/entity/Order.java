package com.kafka.order_service.entity;

import com.kafka.inventory_service.entity.Inventory;
import com.kafka.user_service.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @EmbeddedId
    private OrderId orderId;

    @NotNull(message = "Order must have a date")
    private Date date;

    @Column(name = "address_to")
    private String addressTo;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private OrderStatus orderStatus;
}
