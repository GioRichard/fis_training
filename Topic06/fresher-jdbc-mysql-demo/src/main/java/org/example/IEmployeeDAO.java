package org.example;

import org.example.util.DateUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface IEmployeeDAO {
    public List<Employee> getAll();

    public boolean add(Employee employee);

    // them nhieu nhan vien cung 1 luc
    // 1 la add tat car // ko

    public  boolean addAll(List<Employee> employeeList);
}
