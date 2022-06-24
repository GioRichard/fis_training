package vn.fis.training.ordermanagement.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.fis.training.ordermanagement.model.Order;
import vn.fis.training.ordermanagement.model.OrderStatus;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository {
    Page<Order> findAllByStatus(OrderStatus orderStatus,Pageable pageable);
    Page<Order> findAllByOrderDatetimeBetween(LocalDateTime fromDate,LocalDateTime toDate,Pageable pageable);
}
