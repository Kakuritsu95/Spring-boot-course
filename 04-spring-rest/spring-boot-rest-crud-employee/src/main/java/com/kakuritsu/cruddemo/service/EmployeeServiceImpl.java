package com.kakuritsu.cruddemo.service;

import com.kakuritsu.cruddemo.dao.EmployeeDAO;
import com.kakuritsu.cruddemo.dao.util.MessageHelper;
import com.kakuritsu.cruddemo.entity.Employee;
import com.kakuritsu.cruddemo.exceptions.EmployeeNotFoundException;
import jakarta.transaction.Transactional;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
     EmployeeDAO employeeDAO;
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override public Employee findById(int id){
       return employeeDAO.findById(id);
    }
    @Transactional
    @Override
    public Employee save(Employee employee){
        return employeeDAO.save(employee);
    }
    @Transactional
    @Override
    public void deleteById(int id){
         employeeDAO.deleteById(id);
    }

}
