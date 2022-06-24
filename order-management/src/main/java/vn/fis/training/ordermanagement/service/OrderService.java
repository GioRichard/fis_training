package vn.fis.training.ordermanagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.fis.training.ordermanagement.dto.OrderDTO;

import javax.transaction.Transactional;

public interface OrderService {
    Page<OrderDTO> findAll(Pageable pageable);

    @Transactional
    Page<OrderDTO> findAllPaidOrders(Pageable pageable);
}

//khi sua doi ko bi anh huong layer trc
