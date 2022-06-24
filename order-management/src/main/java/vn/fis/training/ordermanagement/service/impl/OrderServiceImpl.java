package vn.fis.training.ordermanagement.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.fis.training.ordermanagement.dto.OrderDTO;
import vn.fis.training.ordermanagement.model.OrderStatus;
import vn.fis.training.ordermanagement.repository.OrderRepository;
import vn.fis.training.ordermanagement.service.OrderService;

import javax.transaction.Transactional;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
    @Override
    public Page<OrderDTO> findAll(Pageable pageable) {
        log.info("Query all order: Page Number: {}, Page Size: {}",pageable.getPageNumber(), pageable.getPageSize());
        return orderRepository.findAll(pageable).map(OrderDTO.Mapper::fromEntity);
    }

    @Transactional
    @Override
    public Page<OrderDTO> findAllPaidOrders(Pageable pageable){
        return orderRepository.findAllByStatus(OrderStatus.PAID,pageable).map(OrderDTO.Mapper::fromEntity);
    }

}

