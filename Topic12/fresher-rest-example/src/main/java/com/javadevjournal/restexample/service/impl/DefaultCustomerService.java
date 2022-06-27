package com.javadevjournal.restexample.service.impl;

import com.javadevjournal.restexample.data.Customer;
import com.javadevjournal.restexample.repo.CustomerRepository;
import com.javadevjournal.restexample.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultCustomerService implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer, String id) {

        Optional<Customer> originalCustomer = customerRepository.findById(Long.valueOf(id));
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(String email, String id) {
        Optional<Customer> originalCustomer = customerRepository.findById(Long.valueOf(id));
        Customer customer = originalCustomer.get();
        customer.setEmail(email);
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<>();
//        Iterator<Customer> iterable = customerRepository.findAll();
//        while (iterable.hasNext())
//            customers.add(iterable.next());
        for (Customer cus: customerRepository.findAll()) {
            customers.add(cus);
        }
        return customers;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
