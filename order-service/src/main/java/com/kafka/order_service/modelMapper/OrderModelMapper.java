package com.kafka.order_service.modelMapper;

import com.kafka.order_service.dto.OrderDto;
import com.kafka.order_service.dto.POSTOrderDto;
import com.kafka.order_service.entity.Order;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderModelMapper {

    private final ModelMapper mapper;

    public OrderDto map_Order_OrderDto(Order order){
        return mapper.map(order, OrderDto.class);
    }

    public Order map_POSTOrderDto_Order(POSTOrderDto postOrderDto){
        return mapper.map(postOrderDto, Order.class);
    }

    public Order map_OrderDto_Order(OrderDto orderDto){
        return mapper.map(orderDto, Order.class);
    }


}
