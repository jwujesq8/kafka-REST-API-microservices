package com.kafka.inventory_service.controller;

import com.kafka.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;


}
