package com.kafka.order_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderId implements Serializable {

    @Column(name = "inventory_id", nullable = false)
    private UUID userId;

    @Column(name = "user_id", nullable = false)
    private UUID inventoryId;
}
