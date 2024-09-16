package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;
   @Autowired
   public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    @GetMapping("/list")
    public String listEmployees(Model theModel){
       List<Employee> theEmployees = employeeService.findAll();

       theModel.addAttribute("employees", theEmployees);
       return "employees/list-employees";
    }
    @GetMapping("/form")
    public String employeeAddForm(Model theModel){
       Employee theEmployee = new Employee();
       theModel.addAttribute(theEmployee);
       return "/employees/form";
    }
    @PostMapping("/save")
    String saveEmployeeAndRedirect( @ModelAttribute("employee") Employee employee){
       employeeService.save(employee);
       return "redirect:/employees/list";
    }
    @GetMapping("/delete")
    String deleteEmployeeAndRedirect(@RequestParam("employeeId") int theId){
       employeeService.deleteById(theId);
       return "redirect:/employees/list";
    }

    @GetMapping("/formUpdate")
    String updateEmployeeAndRedirect(Model theModel, @RequestParam int employeeId){
       Employee theEmployee = employeeService.findById(employeeId);
       theModel.addAttribute(theEmployee);
       return "/employees/form";
    }


}
