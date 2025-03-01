package com.kafka.inventory_service.controller;

import com.kafka.inventory_service.dto.InventoryDto;
import com.kafka.inventory_service.dto.InventoryIdDto;
import com.kafka.inventory_service.dto.POSTInventoryDto;
import com.kafka.inventory_service.service.InventoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
@Validated
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping("/new")
    public InventoryDto addInventory(@RequestBody @Valid POSTInventoryDto postInventoryDto){
        return inventoryService.addInventory(postInventoryDto);
    }
    @PutMapping()
    public InventoryDto updateInventory(@RequestBody @Valid InventoryDto invDto){
        return inventoryService.updateInventoryById(invDto);
    }
    @DeleteMapping()
    public void deleteInventory(@RequestBody @Valid InventoryIdDto invIdDto){
        inventoryService.deleteInventoryById(invIdDto);
    }
    @PostMapping()
    public Optional<InventoryDto> getInventoryById(@RequestBody @Valid InventoryIdDto invIdDto){
        return inventoryService.getInventoryById(invIdDto);
    }
    @GetMapping()
    public List<InventoryDto> showInventoryPaging(@RequestParam(name = "page", defaultValue = "1") int page,
                                                  @RequestParam(name = "size", defaultValue = "3", required = false) int size){
        return inventoryService.showInventoryPaging(page,size);
    }


}
