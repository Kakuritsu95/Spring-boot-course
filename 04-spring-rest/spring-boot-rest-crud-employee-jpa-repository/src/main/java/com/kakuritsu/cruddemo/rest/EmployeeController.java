package com.kakuritsu.cruddemo.rest;


import com.kakuritsu.cruddemo.dao.util.MessageHelper;
import com.kakuritsu.cruddemo.entity.Employee;

import com.kakuritsu.cruddemo.exceptions.EmployeeNotFoundException;
import com.kakuritsu.cruddemo.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

   private EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable int id){
      return  employeeService.findById(id);
    }
   @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        employee.setId(0);
        return employeeService.save(employee);
   }

   @PutMapping("/employees")
   public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
   }

   @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeService.deleteById(id);
        return MessageHelper.employeeDeleted(id);
   }

}
