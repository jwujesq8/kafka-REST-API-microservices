package com.kafka.inventory_service.service;

import com.kafka.inventory_service.dto.InventoryDto;
import com.kafka.inventory_service.dto.InventoryIdDto;
import com.kafka.inventory_service.dto.POSTInventoryDto;
import com.kafka.inventory_service.entity.Inventory;
import com.kafka.inventory_service.modelMapper.InventoryModelMapper;
import com.kafka.inventory_service.reposotiry.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final InventoryModelMapper inventoryModelMapper;

    @Transactional
    public InventoryDto addInventory(POSTInventoryDto invDto) {
        Inventory inventory = inventoryModelMapper.map_POSTInventoryDto_to_Inventory(invDto);
        return inventoryModelMapper.map_Inventory_to_InventoryDto(inventoryRepository.save(inventory));
    }

    @Transactional
    public InventoryDto updateInventoryById(InventoryDto invDto) {
        Inventory inventory = inventoryModelMapper.map_InventoryDto_to_Inventory(invDto);
        return inventoryModelMapper.map_Inventory_to_InventoryDto(inventoryRepository.save(inventory));
    }

    public void deleteInventoryById(InventoryIdDto invIdDto) {
        inventoryRepository.deleteById(invIdDto.getId());
    }

    public Optional<InventoryDto> getInventoryById(InventoryIdDto invIdDto) {
        return Optional.ofNullable(inventoryModelMapper.map_Inventory_to_InventoryDto(
                inventoryRepository.findById(invIdDto.getId()).orElse(null)
        ));
    }

    public List<InventoryDto> showInventoryPaging(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Inventory> inventoryPage = inventoryRepository.findAll(pageable);
        return inventoryPage.getContent().stream()
                .map(inventoryModelMapper::map_Inventory_to_InventoryDto)
                .collect(Collectors.toList());
    }
}
