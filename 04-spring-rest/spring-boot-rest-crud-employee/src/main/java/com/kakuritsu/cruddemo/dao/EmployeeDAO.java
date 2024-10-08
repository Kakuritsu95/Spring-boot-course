package com.kakuritsu.cruddemo.dao;

import com.kakuritsu.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
   public List<Employee> findAll();

   public Employee findById(int id);

   public Employee save(Employee employee);

   public void deleteById(int id);
}
