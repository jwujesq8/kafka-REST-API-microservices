package com.kafka.user_service.service;

import com.kafka.inventory_service.dto.InventoryDto;
import com.kafka.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private static final String INVENTORY_SERVICE_URL="http://localhost:8081";


    public void signUp() {

    }

    public void logIn() {

    }

    public void confirmAdmin() {

    }

    public List<InventoryDto> requestAndShowInventoryList(int page, int size) {
        WebClient webClient = WebClient.create(INVENTORY_SERVICE_URL);

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/inventory")
                        .queryParam("page", page)
                        .queryParam("size", size)
                        .build()
                )
                .retrieve()
                .bodyToFlux(InventoryDto.class)
                .collectList()
                .block();

    }

    public void checkOrderStatus() {

    }
}
