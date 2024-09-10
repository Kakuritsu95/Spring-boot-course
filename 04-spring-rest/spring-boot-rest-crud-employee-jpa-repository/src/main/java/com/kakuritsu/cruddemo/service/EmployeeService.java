package com.kakuritsu.cruddemo.service;

import com.kakuritsu.cruddemo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService  {

    public List<Employee> findAll();

    public Employee findById(int id);

    public Employee save(Employee employee);

    public void deleteById(int id);
}
