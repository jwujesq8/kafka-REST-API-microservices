package com.kafka.inventory_service.modelMapper;

import com.kafka.inventory_service.dto.InventoryDto;
import com.kafka.inventory_service.dto.POSTInventoryDto;
import com.kafka.inventory_service.entity.Inventory;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InventoryModelMapper {

    private final ModelMapper mapper;

    public Inventory map_InventoryDto_to_Inventory(InventoryDto invDto) {
        return mapper.map(invDto, Inventory.class);
    }

    public InventoryDto map_Inventory_to_InventoryDto(Inventory inventory) {
        return mapper.map(inventory, InventoryDto.class);
    }

    public Inventory map_POSTInventoryDto_to_Inventory(POSTInventoryDto POSTInvDto) {
        return mapper.map(POSTInvDto, Inventory.class);
    }
}
