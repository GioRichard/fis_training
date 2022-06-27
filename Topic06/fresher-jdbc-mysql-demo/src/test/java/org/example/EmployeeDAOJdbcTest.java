package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeDAOJdbcTest {
    @Test
    public void testGetAll() {
        IEmployeeDAO employeeDAO = new EmployeeDAOJdbc();
        List<Employee> employeeList = employeeDAO.getAll();

        System.out.println(employeeList);
    }

    @Test
    void add() {
        IEmployeeDAO employeeDAO = new EmployeeDAOJdbc();
        Employee employee = new Employee(20, "Nguyen Thanh Nhan", 103.);

        assertTrue(employeeDAO.add(employee));

        //System.out.println(employeeDAO.getAll());
    }

    @Test
    public void addAll(){
        EmployeeDAOJdbc employeeDAO = new EmployeeDAOJdbc();
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(RandomGenerator.getDefault().nextLong(11)
                ,"Nguyen Tinh",RandomGenerator.getDefault().nextDouble(1002)));

        employeeList.add(new Employee(RandomGenerator.getDefault().nextLong(12)
                ,"Nguyen Trung",RandomGenerator.getDefault().nextDouble(560)));

        employeeDAO.addAll(employeeList);


        assertEquals(2,employeeList.size());
    }

}