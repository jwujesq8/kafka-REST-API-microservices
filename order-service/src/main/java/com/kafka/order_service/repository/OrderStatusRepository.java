package com.kafka.order_service.repository;

import com.kafka.order_service.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {

    public OrderStatus findByStatus(String status);
}
