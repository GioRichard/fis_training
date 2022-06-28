package com.fis.OrderManagementSystem.dto;

import com.fis.OrderManagementSystem.model.Order;
import com.fis.OrderManagementSystem.model.OrderItem;
import com.fis.OrderManagementSystem.model.mum.OrderStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {
    private Long id;

    private LocalDateTime orderDateTime;

    private Long customerId;

    private List<OrderItem> orderItems;

    private Double totalAmount;

    private OrderStatus status;

    public static class Mapper{
        public static  OrderDTO fromEntity(Order order) {
            return OrderDTO.builder().id(order.getId())
                    .orderDateTime(order.getOrderDateTime())
                    .orderItems(order.getOrderItems())
                    .customerId(order.getCustomer().getId())
                    .totalAmount(order.getTotalAmount())
                    .status(order.getStatus())
                    .build();
        }
    }
}
