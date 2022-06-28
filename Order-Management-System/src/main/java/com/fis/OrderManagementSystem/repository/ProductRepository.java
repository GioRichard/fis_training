package com.fis.OrderManagementSystem.repository;

import com.fis.OrderManagementSystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
