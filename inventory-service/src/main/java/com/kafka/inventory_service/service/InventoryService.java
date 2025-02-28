package com.kafka.inventory_service.service;

import com.kafka.inventory_service.dto.InventoryDto;
import com.kafka.inventory_service.dto.InventoryIdDto;
import com.kafka.inventory_service.dto.POSTInventoryDto;
import com.kafka.inventory_service.entity.Inventory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InventoryService {

    InventoryDto addInventory(POSTInventoryDto invDto);
    void deleteInventoryById(InventoryIdDto invIdDto);
    InventoryDto updateInventoryById(InventoryDto invDto);
    Optional<InventoryDto> getInventoryById(InventoryIdDto invIdDto);
    List<InventoryDto> showInventoryPaging(int page, int size);

}
