package com.fis.OrderManagementSystem.controller;

import com.fis.OrderManagementSystem.dto.CustomerDTO;
import com.fis.OrderManagementSystem.model.Customer;
import com.fis.OrderManagementSystem.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@Slf4j
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    private  CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/{pageNumber}/{pageSize}")
    public Page<CustomerDTO> findAll(@PathVariable(name="pageNumber") Integer pageNumber, @PathVariable(name="pageSize") Integer pageSize) {
        log.info("Request All Order. PageNumber: {}, PageSize: {}", pageNumber, pageSize);
        return customerService.findAll(PageRequest.of(pageNumber, pageSize));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable(name = "customerId")Long customerId){
        CustomerDTO customerDTO = customerService.findById(customerId);
        return new ResponseEntity<>(customerDTO, HttpStatus.ACCEPTED);
    }

    @PutMapping("/")
    public Customer create(@RequestBody Customer customer){
        log.info("inside customer of CustomerController");
        return  customerService.create(customer);
    }

    @PostMapping("/{update}/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") Long customerId, @RequestBody Customer customer){
        return customerService.updateCustomer(customerId, customer);
    }

    @DeleteMapping("/{delete}/{customerId}")
    public Long deleteCustomerById(@PathVariable("customerId") Long customerId) {
        customerService.deleteCustomerById(customerId);
        return customerId;
    }





}
