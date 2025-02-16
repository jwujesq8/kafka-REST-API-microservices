package com.kafka.inventory_service.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String inventory;
    private float price_per_one;
    private int quantity;
}
