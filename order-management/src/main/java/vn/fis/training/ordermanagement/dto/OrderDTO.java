package vn.fis.training.ordermanagement.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import vn.fis.training.ordermanagement.model.Order;
import vn.fis.training.ordermanagement.model.OrderItem;
import vn.fis.training.ordermanagement.model.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;


    private LocalDateTime orderDateTime;


    private Long customerId;

    @JsonBackReference
    private List<OrderItem> orderItems;


    private Double totalAmount;

    private OrderStatus status;

    public static class Mapper{
        public  static OrderDTO fromEntity(Order order){
            return OrderDTO.builder().id(order.getId())
                    .orderDateTime(order.getOrderDateTime())
                    .orderItems(order.getOrderItems())
                    .customerId(order.getCustomer().getId())
                    .totalAmount(order.getTotalAmount())
                    .build();
        }
    }
}
