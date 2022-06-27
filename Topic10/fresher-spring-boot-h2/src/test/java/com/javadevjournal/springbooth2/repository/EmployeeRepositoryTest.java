package com.javadevjournal.springbooth2.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryTest {
    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void testFindAll(){
        System.out.println(employeeRepository.findAll());
    }

    @Test
    public void testFindById(){
        System.out.println(employeeRepository.findById(1));
    }
}