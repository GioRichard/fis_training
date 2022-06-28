package com.fis.OrderManagementSystem.dto;

import com.fis.OrderManagementSystem.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrderItemDTO {
    private  Long orderId;
    private  Long productId;
    private Integer quantity;
    public static class Mapper{
        public static  CreateOrderItemDTO fromEntity(OrderItem orderItem) {
            return CreateOrderItemDTO.builder().orderId(orderItem.getId())
                    .productId(orderItem.getProduct().getId())
                    .quantity(orderItem.getQuantity())
                    .build();
        }
    }
}
