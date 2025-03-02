package com.kafka.order_service.dto;

import com.kafka.order_service.entity.OrderStatus;
import com.kafka.user_service.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class POSTOrderDto {

    @NotNull(message = "Order must have a client id")
    private UUID userId;

    @NotNull(message = "Order must have an inventory id")
    private UUID inventoryId;

    @NotNull(message = "Order must have a destination address")
    private String addressTo;


}
