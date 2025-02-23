package com.kafka.payment_service.dto;

import com.kafka.order_service.entity.Order;
import com.kafka.payment_service.entity.PaymentId;
import com.kafka.payment_service.entity.PaymentStatus;
import com.kafka.user_service.entity.User;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class PaymentDto {

    @NotNull(message = "Payment must have user id")
    private UUID userId;

    @NotNull(message = "Payment must have order id")
    private UUID orderId;

    private Date date;

    @NotNull(message = "Payment must have price")
    private float price;

    @Pattern(regexp = "payment-(in-progress|completed)")
    private String status;

}
