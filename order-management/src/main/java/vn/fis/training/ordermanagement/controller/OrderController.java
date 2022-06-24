package vn.fis.training.ordermanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.fis.training.ordermanagement.dto.OrderDTO;
import vn.fis.training.ordermanagement.service.OrderService;

@Slf4j
@RestController
@RequestMapping("/api/order")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService =orderService;
    }

    @GetMapping
    public Page<OrderDTO> findAll(@PathVariable(name = "pageNumber")
                                  Integer pageNumber, @PathVariable(name = "pageSize") Integer pageSize){
        log.info("Query all Order. Page: {}, PageSize; {}",pageNumber,pageSize);
        return orderService.findAll(PageRequest.of(pageNumber,pageSize));
    }
}

/*
GET http://localhost:8080/api/order/{pageNumber}/pageSize
 */