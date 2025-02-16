package com.kafka.order_service;

import com.kafka.inventory_service.InventoryServiceApplication;
import com.kafka.inventory_service.reposotiry.InventoryRepository;
import com.kafka.order_service.repository.OrderRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.stream.Collectors;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(OrderServiceApplication.class, args);

	}

}
