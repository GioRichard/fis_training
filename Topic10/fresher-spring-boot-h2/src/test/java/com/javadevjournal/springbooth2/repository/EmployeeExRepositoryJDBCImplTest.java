package com.javadevjournal.springbooth2.repository;

import com.javadevjournal.springbooth2.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeExRepositoryJDBCImplTest {
    private EmployeeExRepository employeeExRepository;
    @Test
    void get() {
        Optional<Employee> opt = employeeExRepository.get(1);
        System.out.println(opt.get());
    }
}