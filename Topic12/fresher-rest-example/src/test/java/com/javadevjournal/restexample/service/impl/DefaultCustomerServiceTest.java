package com.javadevjournal.restexample.service.impl;

import com.javadevjournal.restexample.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DefaultCustomerServiceTest {
    @Autowired
    CustomerService customerService;
    @Test
    void saveCustomer() {
        System.out.println(customerService.getAllCustomer());
    }

    @Test
    void updateCustomer() {
    }

    @Test
    void testSaveCustomer() {
    }
}