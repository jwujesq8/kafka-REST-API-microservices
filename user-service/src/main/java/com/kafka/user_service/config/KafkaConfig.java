package com.kafka.user_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    private static final String REGISTER_ORDER_TOPIC = "order-register";

    @Bean
    public NewTopic topic(){

        return TopicBuilder
                .name(REGISTER_ORDER_TOPIC)
                .build();
    }
}
