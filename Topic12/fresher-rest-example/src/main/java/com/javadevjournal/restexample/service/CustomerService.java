package com.javadevjournal.restexample.service;

import com.javadevjournal.restexample.data.Customer;

import java.util.List;

public interface CustomerService {

    public Customer saveCustomer(Customer customer, String id);
    public Customer updateCustomer(String email, String id);
    public List<Customer> getAllCustomer();
    public Customer saveCustomer(Customer customer);
}
