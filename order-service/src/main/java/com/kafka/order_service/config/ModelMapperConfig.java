package com.kafka.order_service.config;

import com.kafka.order_service.dto.OrderDto;
import com.kafka.order_service.dto.POSTOrderDto;
import com.kafka.order_service.entity.Order;
import com.kafka.order_service.entity.OrderId;
import com.kafka.order_service.entity.OrderStatus;
import com.kafka.order_service.repository.OrderStatusRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.internal.Pair;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
@RequiredArgsConstructor
public class ModelMapperConfig {

    private final OrderStatusRepository orderStatusRepository;

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setImplicitMappingEnabled(false);

        // CONVERTORS
                // String -> OrderStatus
                Converter<String, OrderStatus> converter_StatusString_OrderStatus = statusString ->
                        orderStatusRepository.findByStatus(statusString.getSource());

                // OrderStatus -> String
                Converter<OrderStatus, String> converter_OrderStatus_StatusString = orderStatus ->
                        orderStatus.getSource().getStatus();

                // OrderId -> UUID
                Converter<OrderId, UUID> converter_OrderId_UserId = orderId -> orderId.getSource().getUserId();
                Converter<OrderId, UUID> converter_OrderId_InventoryId = orderId -> orderId.getSource().getInventoryId();


        // Order->OrderDto
        // + OrderId orderId -> UUID userId, UUID inventoryId
        // + OrderStatus orderStatus -> String status
        TypeMap<Order, OrderDto> typeMap_Order_OrderDto = mapper.createTypeMap(Order.class, OrderDto.class);
        typeMap_Order_OrderDto.addMappings(mapping -> mapping
                .using(converter_OrderId_UserId)
                .map(Order::getOrderId, OrderDto::setUserId));
        typeMap_Order_OrderDto.addMappings(mapping -> mapping
                .using(converter_OrderId_InventoryId)
                .map(Order::getOrderId, OrderDto::setInventoryId));
        typeMap_Order_OrderDto.addMappings(mapping -> mapping
                .using(converter_OrderStatus_StatusString)
                .map(Order::getOrderStatus, OrderDto::setStatus));
        typeMap_Order_OrderDto.implicitMappings();

        // POSTOrderDto->Order
        // + UUID userId, UUID inventoryId -> OrderId orderId
        TypeMap<POSTOrderDto, Order> typeMap_POSTOrderDto_Order = mapper.createTypeMap(POSTOrderDto.class, Order.class);
        typeMap_POSTOrderDto_Order.addMappings(mapping -> mapping.skip(Order::setOrderId));
        typeMap_POSTOrderDto_Order.setPostConverter(context -> {
            POSTOrderDto source = context.getSource();
            Order destination = context.getDestination();
            OrderId orderId = new OrderId(source.getUserId(), source.getInventoryId());
            destination.setOrderId(orderId);
            return destination;
        });
        typeMap_POSTOrderDto_Order.implicitMappings();

        // OrderDto->Order
        // + UUID userId, UUID inventoryId -> OrderId orderId
        // + String status -> OrderStatus orderStatus
        TypeMap<OrderDto, Order> typeMap_OrderDto_Order = mapper.createTypeMap(OrderDto.class, Order.class);
        typeMap_OrderDto_Order.addMappings(mapping -> mapping.skip(Order::setOrderId));
        typeMap_OrderDto_Order.addMappings(mapping -> mapping
                .using(converter_StatusString_OrderStatus)
                .map(OrderDto::getStatus, Order::setOrderStatus));
        typeMap_OrderDto_Order.setPostConverter(context -> {
            OrderDto source = context.getSource();
            Order destination = context.getDestination();
            OrderId orderId = new OrderId(source.getUserId(), source.getInventoryId());
            destination.setOrderId(orderId);
            return destination;
        });
        typeMap_OrderDto_Order.implicitMappings();

        return mapper;
    }
}