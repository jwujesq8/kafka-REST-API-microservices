package com.kafka.inventory_service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class InventoryIdDto {

    private UUID id;
}
