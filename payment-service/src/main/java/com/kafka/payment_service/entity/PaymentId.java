package com.kafka.payment_service.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PaymentId implements Serializable {

    private UUID userId;
    private UUID orderId;
}
