package com.javadevjournal.springbooth2.repository;

import com.javadevjournal.springbooth2.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class EmployeeExRepositoryJDBCImpl implements EmployeeExRepository {
    public static  String EMP_SQL = "SELECT id,name,salary FROM employee WHERE id =?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Employee> get(Integer id) {
        Employee employee = jdbcTemplate.queryForObject(
                EMP_SQL,
                new BeanPropertyRowMapper<Employee>(Employee.class),
                id.intValue());
        if (employee != null)
            return Optional.of(employee);
        return Optional.empty();
    }


}
