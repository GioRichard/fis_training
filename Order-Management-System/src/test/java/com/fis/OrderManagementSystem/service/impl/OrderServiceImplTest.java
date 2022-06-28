package com.fis.OrderManagementSystem.service.impl;

import com.fis.OrderManagementSystem.dto.OrderDTO;
import com.fis.OrderManagementSystem.model.Customer;
import com.fis.OrderManagementSystem.model.Order;
import com.fis.OrderManagementSystem.model.OrderItem;
import com.fis.OrderManagementSystem.model.Product;
import com.fis.OrderManagementSystem.model.mum.OrderStatus;
import com.fis.OrderManagementSystem.repository.OrderRepository;
import com.fis.OrderManagementSystem.service.CustomerService;
import com.fis.OrderManagementSystem.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
class OrderServiceImplTest {
    private OrderServiceImpl orderService;
    private ProductService productService;
    private CustomerService customerService;

    private OrderRepository orderRepository;
    private Order order;
    private Product product;
    private Customer customer;
    private Pageable pageable;

    @BeforeEach
    void init() {
        pageable = mock(Pageable.class);
        orderRepository = mock(OrderRepository.class);
        customerService = mock(CustomerService.class);
        productService = mock(ProductService.class);
        orderService = new OrderServiceImpl(orderRepository);
        customer = Customer.builder()
                .id(1L)
                .name("Minh Duc")
                .mobile("0123456789")
                .address("Ha Noi")
                .build();
        product = Product.builder()
                .id(1L)
                .name("Cam")
                .avaiable(100L)
                .price(8000.0)
                .build();
        OrderItem orderItem = OrderItem.builder()
                .id(1L)
                .amount(16000.0)
                .quantity(2)
                .product(product)
                .build();
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(orderItem);
        order = Order.builder()
                .id(1L)
                .customer(customer)
                .totalAmount(1000.0)
                .status(OrderStatus.CREATED)
                .orderDateTime(LocalDateTime.now())
                .orderItems(orderItems)
                .build();
    }
    @Test
    void findAll() {
        List<Order> orderList = new ArrayList<>();
        orderList.add(order);
        Page<Order> orders = new PageImpl<>(orderList);

        when(orderRepository.findAll(pageable)).thenReturn(orders);
        log.info("Order List size: {}", orderList.size());
        Page<OrderDTO> orderDTOPage = orderService.findAll(pageable);
        orderDTOPage.forEach(orderInPage -> log.info("Order in page: {}", orderInPage));
        assertEquals(orderDTOPage.getTotalElements(), orders.getTotalElements());
        verify(orderRepository, times(1)).findAll(pageable);
    }

    @Test
    void findById() {
        when(orderRepository.findById(1L)).thenReturn(Optional.ofNullable(order));
        OrderDTO orderDTO = orderService.findById(1L);
        log.info("Order has id = 1L: {}", order);
        assertThat(orderDTO).isNotNull();
        assertThat(orderDTO.getTotalAmount()).isEqualTo(1000);
    }

}