package com.fis.OrderManagementSystem.service.impl;

import com.fis.OrderManagementSystem.dto.CustomerDTO;
import com.fis.OrderManagementSystem.model.Customer;
import com.fis.OrderManagementSystem.repository.CustomerRepository;
import com.fis.OrderManagementSystem.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CustomerDTO> findAll(Pageable pageable) {
        log.info("Query all Customer. PageNumber: {}, PageSize: {}", pageable.getPageNumber(), pageable.getPageSize());
        return customerRepository.findAll(pageable).map(CustomerDTO.Mapper::fromEntity);
    }

    @Override
    public CustomerDTO findById(Long customerId) {
        return CustomerDTO.Mapper.fromEntity(customerRepository.findById(customerId).orElseThrow(
                () -> {throw new IllegalArgumentException(String.format("Not found order with id %s",customerId));}));
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long customerId, Customer customer) {
        Customer customer1 = customerRepository.findById(customerId).get();

        if(Objects.nonNull(customer.getName()) &&
                !"".equalsIgnoreCase(customer.getName())) {
            customer1.setName(customer.getName());
        }

        if(Objects.nonNull(customer.getAddress()) &&
                !"".equalsIgnoreCase(customer.getAddress())) {
            customer1.setAddress(customer.getAddress());
        }

        if(Objects.nonNull(customer.getMobile()) &&
                !"".equalsIgnoreCase(customer.getMobile())) {
            customer1.setMobile(customer.getMobile());
        }
        return customerRepository.save(customer1);
    }

    @Override
    public void deleteCustomerById(Long customerId) {
         customerRepository.deleteById(customerId);
    }
}
