package vn.fis.training.ordermanagement.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findAllNameOnly() {
        productRepository.findAllNameOnly().forEach(productDTO -> log.info("product Name: {}",productDTO.getName()));
    }
}