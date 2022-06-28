package com.fis.OrderManagementSystem.service.impl;

import com.fis.OrderManagementSystem.dto.CustomerDTO;
import com.fis.OrderManagementSystem.model.Customer;
import com.fis.OrderManagementSystem.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
class CustomerServiceImplTest {
    private CustomerServiceImpl customerService;
    private CustomerRepository customerRepository;
    private Customer customer;
    private Pageable pageable;

    @BeforeEach
    void init() {
        pageable = mock(Pageable.class);
        customerRepository = mock(CustomerRepository.class);
        customerService = new CustomerServiceImpl(customerRepository);
        customer = Customer.builder()
                .id(1L)
                .name("Tran Dat")
                .address("Da Nang")
                .mobile("09998976")
                .build();
    }


    @Test
    void findAll() {
        List<Customer> customerList = new ArrayList<>();
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Customer customer3 = new Customer();
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        Page<Customer> customers = new PageImpl<>(customerList);

        when(customerRepository.findAll(pageable)).thenReturn(customers);
        log.info("Customer List size: {}", customerList.size());
        Page<CustomerDTO> customerDTOPage = customerService.findAll(pageable);

        assertEquals(customerDTOPage.getTotalElements(), customers.getTotalElements());
        verify(customerRepository, times(1)).findAll(pageable);
    }

    @Test
    void findById() {
        when(customerRepository.findById(1L)).thenReturn(Optional.ofNullable(customer));
        CustomerDTO customer1 = customerService.findById(1L);
        log.info("Customer has id = 1L: {}", customer);
        assertThat(customer1).isNotNull();
        assertThat(customer1.getName()).isEqualTo("Tran Dat");
    }

    @Test
    void create() {
        Customer customer3 = Customer.builder()
                .name("Nguyen Anh")
                .address("Vinh Phuc")
                .mobile("099899999")
                .build();

    }

    @Test
    void updateCustomer() {
        customer.setMobile("099889898");
        customer.setAddress("Tu Hoang");
        when(customerRepository.save(customer)).thenReturn(customer);

        Customer customer1 = customer.builder()
                .address("Tu Hoang")
                .mobile("099889898")
                .build();

        when(customerRepository.findById(1L)).thenReturn(Optional.ofNullable(customer));
        Customer updatedCustomer = customerService.updateCustomer(1L, customer1);
        log.info("Update after: {}", updatedCustomer);
        assertThat(updatedCustomer.getMobile()).isEqualTo("099889898");
    }

    @Test
    void deleteDepartmentById() {
        Long id = 1L;
        willDoNothing().given(customerRepository).deleteById(id);
        customerService.deleteCustomerById(id);
        verify(customerRepository, times(1)).deleteById(id);
    }
}