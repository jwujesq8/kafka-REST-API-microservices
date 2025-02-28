package com.kafka.inventory_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Entity
@Table(name = "inventory")
@Getter
@Setter
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;

    @Column(name = "price_per_one")
    private float pricePerOne;
    private int quantity;
}
