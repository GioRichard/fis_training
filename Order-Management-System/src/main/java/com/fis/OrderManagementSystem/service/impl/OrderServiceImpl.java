package com.fis.OrderManagementSystem.service.impl;

import com.fis.OrderManagementSystem.dto.CreateOrderItemDTO;
import com.fis.OrderManagementSystem.dto.OrderDTO;
import com.fis.OrderManagementSystem.model.Order;
import com.fis.OrderManagementSystem.model.OrderItem;
import com.fis.OrderManagementSystem.model.Product;
import com.fis.OrderManagementSystem.model.mum.OrderStatus;
import com.fis.OrderManagementSystem.repository.OrderItemRepository;
import com.fis.OrderManagementSystem.repository.OrderRepository;
import com.fis.OrderManagementSystem.repository.ProductRepository;
import com.fis.OrderManagementSystem.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
    @Override
    @Transactional(readOnly = true)
    public Page<OrderDTO> findAll(Pageable pageable) {
        log.info("Query all Order. PageNumber: {}, PageSize: {}", pageable.getPageNumber(), pageable.getPageSize());
        return orderRepository.findAll(pageable).map(OrderDTO.Mapper::fromEntity);
    }

    @Override
    public OrderDTO findById(Long orderId) {
        return OrderDTO.Mapper.fromEntity(orderRepository.findById(orderId).orElseThrow(
                () -> {throw new IllegalArgumentException(String.format("Not found order with id %s",orderId));}));
    }

    @Override
    public Order addOrderItem(CreateOrderItemDTO createOrderItemDTO) {
        Order order = orderRepository.findById(createOrderItemDTO.getOrderId()).orElseThrow(
                () -> new IllegalArgumentException("Order Not Found. Order Id " + createOrderItemDTO.getOrderId()));;
        Product product = productRepository.findById(createOrderItemDTO.getProductId()).orElseThrow(
                () -> new IllegalArgumentException("Product Not Found. Product Id " + createOrderItemDTO.getProductId()));;
        OrderItem orderItem = OrderItem.builder().order(order).product(product).quantity(createOrderItemDTO.getQuantity()).amount(product.getPrice()*createOrderItemDTO.getQuantity()).build();
        if(order.getStatus().equals(OrderStatus.CREATED)){
            order.getOrderItems().add(orderItem);
            order.setTotalAmount(order.getTotalAmount()+orderItem.getAmount());
            order.setTotalAmount(order.getOrderItems().stream().mapToDouble(item->item.getAmount()).sum());

            return order;
        }
        return null;
    }


    @Override
    public Order paidOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).get();
        if(order.getStatus().equals(OrderStatus.CREATED)){
            order.setStatus(OrderStatus.PAID);
            orderRepository.save(order);
            return order;
        }
        return null;
    }

    @Override
    public Order cancelOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).get();
        if(order.getStatus().equals(OrderStatus.CREATED)){
            order.setStatus(OrderStatus.CANCELLED);
            orderRepository.save(order);
            return order;
        }
        return null;
    }

    @Override
    public Order removeOrderItem(Long orderItemId) {
        Order order = orderRepository.findById(orderItemId).get();
        if(order.getStatus().equals(OrderStatus.CREATED)){
            orderRepository.deleteById(order.getId());
            return order;
        }
        return null;
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrderById(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
