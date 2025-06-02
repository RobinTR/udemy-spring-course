package com.robn.springboot.thymeleafdemo.dao;

import com.robn.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // No additional methods are needed as JpaRepository provides basic CRUD operations
    List<Employee> findAllByOrderByLastNameAsc(); // Optional: Custom method to find all employees ordered by last name
}
