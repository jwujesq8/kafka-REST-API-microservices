package com.kafka.user_service;

import com.kafka.user_service.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {

//		SpringApplication.run(UserServiceApplication.class, args);
		ApplicationContext context = SpringApplication.run(UserServiceApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);

		System.out.println(userRepository.findAll());
	}

}
