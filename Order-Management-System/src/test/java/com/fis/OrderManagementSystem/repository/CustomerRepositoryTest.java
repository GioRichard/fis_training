package com.fis.OrderManagementSystem.repository;

import com.fis.OrderManagementSystem.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;


    @Test
    void findAllCustomer(){
        log.info("Customer: {}", customerRepository.findAll());
    }

    @Test
    void createCustomer(){
        Customer customer = Customer.builder().name("Phong").mobile("091888689").address("Vinh Phuc").build();
        customerRepository.save(customer);
        log.info("save customer: {}", customer);
    }

    @Test
    void updateCustomer(){
        List<Customer> customerList = customerRepository.findAll();
        Customer customer = new Customer();

        customer.setName("Nguyen Tinh");
        Customer updatedCustomer = customerRepository.save(customer);
        log.info("Update customer: {}", updatedCustomer);
        assertThat("Nguyen Tinh".equals(customerRepository.findById(7L).orElseThrow().getName()));
    }

    @Test
    void deleteCustomerById(){
        assertEquals("091888689",customerRepository.findById(8L).get().getMobile());
    }
}
