package com.kafka.order_service.service;

import com.kafka.order_service.dto.OrderDto;
import com.kafka.order_service.dto.POSTOrderDto;
import com.kafka.order_service.entity.OrderId;

import java.util.Optional;

public interface OrderService {

    public OrderDto addOrder(POSTOrderDto postOrderDto);

    public OrderDto updateOrder(OrderDto orderDto);

    public Optional<OrderDto> getOrderById(OrderId orderId);

    public void deleteOrderById(OrderId orderId);

    // kafka consumer
    public OrderDto updateOrderStatus(OrderDto orderDto);

}
