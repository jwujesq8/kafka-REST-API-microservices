package com.kafka.inventory_service.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Getter
@Setter
public class InventoryIdDto {

    UUID id;
}
