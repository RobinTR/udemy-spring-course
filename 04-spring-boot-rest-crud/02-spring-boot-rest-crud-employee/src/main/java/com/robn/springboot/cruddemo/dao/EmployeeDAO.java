package com.robn.springboot.cruddemo.dao;

import com.robn.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
