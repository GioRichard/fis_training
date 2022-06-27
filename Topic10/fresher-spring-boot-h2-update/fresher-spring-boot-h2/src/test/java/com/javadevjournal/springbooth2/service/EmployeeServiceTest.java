package com.javadevjournal.springbooth2.service;

import com.javadevjournal.springbooth2.model.Employee;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;

    @Test
    @Order(1)
    void getAllEmployees() {
        List<Employee> employeeList = employeeService.getAllEmployees();

        assertEquals(5, employeeList.size());
        System.out.println(employeeList);
    }

    @Test
    @Order(2)
    void getEmployeeById_Exist() {
        Employee employee = employeeService.getEmployeeById(1);

        assertEquals("Amy", employee.getName());
        assertEquals(3500.0, employee.getSalary());
    }

    @Test
    @Order(3)
    void getEmployeeById_NotExist() {
        Employee employee = employeeService.getEmployeeById(1);

        employee = employeeService.getEmployeeById(10);
        assertNull(employee);
    }

    @Test
    @Order(4)
    void delete() {
        int numberOfEmployee = employeeService.getAllEmployees().size();

        employeeService.delete(2);

        Employee employee = employeeService.getEmployeeById(2);
        assertNull(employee);

        assertEquals(numberOfEmployee-1, employeeService.getAllEmployees().size());
    }

    @Test
    @Order(5)
    void saveOrUpdate() {
        //Given
        Employee employee = new Employee();
        employee.setName("Nguyen Thanh Phuoc");
        employee.setSalary(3000.);

        int numberOfEmployee = employeeService.getAllEmployees().size();
        employeeService.saveOrUpdate(employee);
        assertEquals(numberOfEmployee+1, employeeService.getAllEmployees().size());

        Optional<Employee> result = employeeService.getAllEmployees().stream().filter(emp -> {
            if(emp.getName().equals("Nguyen Thanh Phuoc"))
                return true;
            else
                return false;
        }).findFirst();

        assertTrue(result.isPresent());
    }
}