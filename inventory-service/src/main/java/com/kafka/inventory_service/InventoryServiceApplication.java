package com.kafka.inventory_service;

import com.kafka.inventory_service.reposotiry.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.stream.Collectors;

@SpringBootApplication
public class InventoryServiceApplication {


	public static void main(String[] args) {

		SpringApplication.run(InventoryServiceApplication.class, args);


	}

}
