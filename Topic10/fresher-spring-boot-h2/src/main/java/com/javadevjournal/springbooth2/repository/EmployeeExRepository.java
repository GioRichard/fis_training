package com.javadevjournal.springbooth2.repository;

import com.javadevjournal.springbooth2.model.Employee;

import java.util.Optional;

public interface EmployeeExRepository {

    Optional<Employee> get(Integer id);
}
