package com.kafka.order_service.service;

import com.kafka.order_service.dto.OrderDto;
import com.kafka.order_service.dto.POSTOrderDto;
import com.kafka.order_service.entity.Order;
import com.kafka.order_service.entity.OrderId;
import com.kafka.order_service.modelMapper.OrderModelMapper;
import com.kafka.order_service.repository.OrderRepository;
import com.kafka.order_service.repository.OrderStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderStatusRepository orderStatusRepository;
    private final OrderModelMapper orderModelMapper;

    public OrderDto addOrder(POSTOrderDto postOrderDto) {
        Order order = orderModelMapper.map_POSTOrderDto_Order(postOrderDto);
        order.setOrderStatus(orderStatusRepository.findByStatus("order-register"));
        order.setDate(Date.from(Instant.now()));
        orderRepository.save(order);
        return orderModelMapper.map_Order_OrderDto(order);
    }

    public OrderDto updateOrder(OrderDto orderDto) {
        Order order = orderModelMapper.map_OrderDto_Order(orderDto);
        orderRepository.save(order);
        return orderModelMapper.map_Order_OrderDto(order);
    }

    public Optional<OrderDto> getOrderById(OrderId orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        return Optional.of(orderModelMapper.map_Order_OrderDto(order));
    }

    public void deleteOrderById(OrderId orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if(order != null){
            order.setOrderStatus(orderStatusRepository.findByStatus("order-cancelled"));
            orderRepository.save(order);
        }
    }

    // TODO: kafka consumer
    public OrderDto updateOrderStatus(OrderDto orderDto) {
        return updateOrder(orderDto);
    }
}
