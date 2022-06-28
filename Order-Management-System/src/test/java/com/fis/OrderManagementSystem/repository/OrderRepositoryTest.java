package com.fis.OrderManagementSystem.repository;

import com.fis.OrderManagementSystem.model.Order;
import com.fis.OrderManagementSystem.model.mum.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class OrderRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;

    @Test
    void createOrder(){
        Order order = Order.builder()
                .orderDateTime(LocalDateTime.now())
                .status(OrderStatus.CREATED)
                .totalAmount(2000.0)
                .build();
        log.info("Saved Order: {}", order);
    }

    @Test
    void findAllOrder(){
        List<Order> orderList = orderRepository.findAll();
        orderList.forEach(Item -> log.info("Order List: {}", Item));
        assertNotNull(orderList);
    }

    @Test
    void updateOrder(){

        Order order = orderRepository.findById(1L).get();

        order.setTotalAmount(4000.0);
        Order updatedOrder = orderRepository.save(order);
        log.info("Update order: {}", updatedOrder);
        assertEquals(4000.0, orderRepository.findById(1L).orElseThrow().getTotalAmount());
    }

    @Test
    void deleteOrder(){
        assertEquals(4000,orderRepository.findById(3L).get().getTotalAmount());

    }

}