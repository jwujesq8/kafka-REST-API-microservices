package com.kafka.inventory_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CheckOrderResponseDto {

    private String serviceName = "Inventory service";
    private String request = "checking for the availability of goods for the order";
    private boolean response;
}
