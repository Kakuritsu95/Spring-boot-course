package com.kakuritsu.cruddemo.dao;


import com.kakuritsu.cruddemo.dao.util.MessageHelper;
import com.kakuritsu.cruddemo.entity.Employee;

import com.kakuritsu.cruddemo.exceptions.EmployeeNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    EntityManager entityManager;
@Autowired
    EmployeeDAOJpaImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
   public List<Employee> findAll(){
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int id){
        return Optional.ofNullable(entityManager.find(Employee.class,id)).orElseThrow(()->new EmployeeNotFoundException(MessageHelper.employeeNotFound(id)));
    }
    @Override
    public Employee save(Employee employee){
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id){
        Employee employeeToDelete = this.findById(id);
        entityManager.remove(employeeToDelete);
    }
}
