package com.kafka.inventory_service.service;

import com.kafka.inventory_service.dto.InventoryDto;

import java.util.List;

public interface InventoryService {

    void editInventory(InventoryDto inventoryDto);
    List<InventoryDto> showInventory(int page, int size);
    void checkOrder(List<InventoryDto> inventoryDtoList);
    void sendCheckOrderResponse(boolean response);

}
