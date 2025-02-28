package com.kafka.user_service.service;

import com.kafka.inventory_service.dto.InventoryDto;

import java.util.List;

public interface UserService {

    public void signUp();

    public void logIn();

    public void confirmAdmin();

    public List<InventoryDto> requestAndShowInventoryList(int page, int size);

    public void checkOrderStatus();

}
