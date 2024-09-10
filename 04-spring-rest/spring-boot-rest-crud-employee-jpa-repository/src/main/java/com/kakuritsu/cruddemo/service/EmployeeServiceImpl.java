package com.kakuritsu.cruddemo.service;


import com.kakuritsu.cruddemo.dao.EmployeeRepository;
import com.kakuritsu.cruddemo.entity.Employee;
import com.kakuritsu.cruddemo.exceptions.EmployeeNotFoundException;
import com.kakuritsu.cruddemo.util.MessageHelper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
     EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(MessageHelper.employeeNotFound(id)));
    }

    @Transactional
    @Override
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }
    @Transactional
    @Override
    public void deleteById(int id){
        this.findById(id);
        employeeRepository.deleteById(id);
    }

}
