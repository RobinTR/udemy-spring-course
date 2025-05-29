package com.robn.springboot.cruddemo.service;

import com.robn.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(Integer id);
    Employee save(Employee employee);
    void deleteById(Integer id);
}
