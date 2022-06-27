package com.javadevjournal.restexample.repo;

import com.javadevjournal.restexample.data.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
