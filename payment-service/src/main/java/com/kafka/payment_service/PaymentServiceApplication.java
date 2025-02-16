package com.kafka.payment_service;

import com.kafka.order_service.OrderServiceApplication;
import com.kafka.order_service.repository.OrderRepository;
import com.kafka.payment_service.repository.PaymentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PaymentServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(PaymentServiceApplication.class, args);

	}

}
