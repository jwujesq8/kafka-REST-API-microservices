package com.kafka.order_service.repository;

import com.kafka.order_service.entity.Order;
import com.kafka.order_service.entity.OrderId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, OrderId> {
}