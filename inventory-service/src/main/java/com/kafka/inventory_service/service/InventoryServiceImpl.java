package com.kafka.inventory_service.service;

import com.kafka.inventory_service.dto.InventoryDto;
import com.kafka.inventory_service.dto.CheckOrderResponseDto;
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
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final InventoryModelMapper inventoryModelMapper;


    public void editInventory(InventoryDto inventoryDto) {

        Inventory inventory = inventoryModelMapper.map_InventoryDto_to_Inventory(inventoryDto);
        inventoryRepository.save(inventory);

    }

    // KAFKA LISTENING and SENDING
    public List<InventoryDto> showInventory(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Inventory> inventoryPage = inventoryRepository.findAll(pageable);
        return inventoryPage.getContent().stream()
                .map(inventoryModelMapper::map_Inventory_to_InventoryDto)
                .collect(Collectors.toList());

    }


    // KAFKA LISTENING
    @Transactional
    public void checkOrder(List<InventoryDto> inventoryDtoList) {

        inventoryDtoList.forEach(inventoryDto -> {
            Optional<Inventory> inventoryDB = inventoryRepository.findById(inventoryDto.getId());

            if (inventoryDB.isPresent()) {
                Inventory inventory = inventoryDB.get();

                if (inventoryDto.getQuantity() <= inventory.getQuantity()) {
                    inventory.setQuantity(inventory.getQuantity() - inventoryDto.getQuantity());
                    inventoryRepository.save(inventory);
                } else {
                    sendCheckOrderResponse(false);
                    throw new IllegalArgumentException("Insufficient quantity for inventory item ID: " + inventoryDto.getId());
                }
            } else {
                sendCheckOrderResponse(false);
                throw new IllegalArgumentException("Inventory item not found for ID: " + inventoryDto.getId());
            }
        });

        sendCheckOrderResponse(true);

    }



    // KAFKA SENDING
    public void sendCheckOrderResponse(boolean response) {
        CheckOrderResponseDto.builder()
                .response(response)
                .build();
    }
}
