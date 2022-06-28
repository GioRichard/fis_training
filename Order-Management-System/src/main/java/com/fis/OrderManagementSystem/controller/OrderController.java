package com.fis.OrderManagementSystem.controller;

import com.fis.OrderManagementSystem.dto.CreateOrderItemDTO;
import com.fis.OrderManagementSystem.dto.OrderDTO;
import com.fis.OrderManagementSystem.model.Order;
import com.fis.OrderManagementSystem.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@Slf4j
public class OrderController {
    private OrderService orderService;

    @Autowired
    private  OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/{pageNumber}/{pageSize}")
    public Page<OrderDTO> findAll(@PathVariable(name="pageNumber") Integer pageNumber,
                                  @PathVariable(name="pageSize") Integer pageSize) {
        log.info("Request All Order. PageNumber: {}, PageSize: {}", pageNumber, pageSize);
        return orderService.findAll(PageRequest.of(pageNumber, pageSize));
    }

    @GetMapping("/findById/{orderId}")
    public OrderDTO findById(@PathVariable(name="orderId")Long orderId) {
        return orderService.findById(orderId);
    }

    @PutMapping("/create")
    public Order create(@RequestBody Order order){
        log.info("inside order of OrderController");
        return  orderService.create(order);
    }

    @DeleteMapping("/{delete}/{orderId}")
    public Long deleteOrderById(@PathVariable("orderId") Long orderId) {
        orderService.deleteOrderById(orderId);
        return orderId;
    }


    @PostMapping("/{addOrderItem}")
    public Order addOrderItem(@PathVariable("orderItemId") Long orderItemId,
                              @RequestBody CreateOrderItemDTO createOrderItemDTO){
        return orderService.addOrderItem(createOrderItemDTO);
    }

    @PostMapping("/{paid}/{orderId}")
    public Order paidOrder(@PathVariable("orderId") Long orderId){
        return orderService.paidOrder(orderId);
    }

    @PostMapping("/{cancel}/{orderId}")
    public Order cancelOrder(@PathVariable("orderId") Long orderId){
        return orderService.cancelOrder(orderId);
    }

    @DeleteMapping("/{removeOrderItem}/{orderItemId}")
    public Order removeOrderItem(@PathVariable("orderItemId") Long orderItemId){
        return orderService.removeOrderItem(orderItemId);
    }
}
