package com.kafka.order_service.dto;

import com.kafka.inventory_service.entity.Inventory;
import com.kafka.order_service.entity.OrderStatus;
import com.kafka.user_service.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
public class OrderDto {

    @NotNull(message = "Order must have a client id")
    private UUID userId;

    @NotNull(message = "Order must have an inventory id")
    private UUID inventoryId;

    private Date date;

    @NotNull(message = "Order must have a destination address")
    private String addressTo;

    @Pattern(regexp = "order-(register|paid|cancelled)", message = "Status must be either 'order-register' or 'order-paid'")
    private String status;

}
