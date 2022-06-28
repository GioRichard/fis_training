package com.fis.OrderManagementSystem.service;

import com.fis.OrderManagementSystem.dto.CustomerDTO;
import com.fis.OrderManagementSystem.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<CustomerDTO> findAll(Pageable pageable);

    CustomerDTO findById(Long customerId);

    Customer create(Customer customer);

    Customer updateCustomer(Long customerId, Customer customer);

    void deleteCustomerById(Long customerId);
}
