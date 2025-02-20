package com.kafka.inventory_service.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class POSTInventoryDto {

    @NotNull(message = "Inventory title cannot be null")
    private String title;

    @NotNull(message = "Price per one cannot be null")
    @DecimalMin(value = "0.00", message = "Price per one must be at least 0.00")
    @DecimalMax(value = "100000.00", message = "Price per one must be no greater than 100000.00")
    private Float pricePerOne;

    @NotNull(message = "Quantity cannot be null")
    @DecimalMin(value = "0", message = "Quantity cannot be negative")
    @DecimalMax(value = "150", message = "Quantity cannot be greater than 150")
    private Integer quantity;

}
