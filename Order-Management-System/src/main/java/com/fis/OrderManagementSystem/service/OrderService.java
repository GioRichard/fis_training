package com.fis.OrderManagementSystem.service;

import com.fis.OrderManagementSystem.dto.CreateOrderItemDTO;
import com.fis.OrderManagementSystem.dto.OrderDTO;
import com.fis.OrderManagementSystem.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    Page<OrderDTO> findAll(Pageable pageable);
    //Page<OrderDTO> findAllPaidOrders(Pageable pageable);

    OrderDTO findById(Long orderId);
    Order addOrderItem(CreateOrderItemDTO createOrderItemDTO);

    Order paidOrder(Long orderId);

    Order cancelOrder(Long orderId);

    Order removeOrderItem(Long orderItemId);

    Order create(Order order);

    void deleteOrderById(Long orderId);
}
