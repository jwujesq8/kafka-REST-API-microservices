package com.kafka.order_service.controller;

import com.kafka.order_service.dto.OrderDto;
import com.kafka.order_service.dto.POSTOrderDto;
import com.kafka.order_service.entity.OrderId;
import com.kafka.order_service.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Validated
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/new")
    public OrderDto addOrder(@RequestBody @Valid POSTOrderDto postOrderDto){
        return orderService.addOrder(postOrderDto);
    }
    @PutMapping()
    public OrderDto updateOrder(@RequestBody @Valid OrderDto orderDto){
        return orderService.updateOrder(orderDto);
    }

    @PostMapping()
    public Optional<OrderDto> getOrderById(@RequestBody @Valid OrderId orderId){
        return orderService.getOrderById(orderId);
    }

    @DeleteMapping()
    public void deleteOrderById(@RequestBody @Valid OrderId orderId){
        orderService.deleteOrderById(orderId);
    }



}
