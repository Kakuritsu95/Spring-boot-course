package com.kakuritsu.simpleRestAPI.service;

import com.kakuritsu.simpleRestAPI.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class StudentImpl implements IStudent {
    private  EntityManager entityManager;
    StudentImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }

    @Override
    public Student getById(int id) {
       return entityManager.find(Student.class,id);
    }

    @Override
    @Transactional
    public void createStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    public List<Student> getAllStudents() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student s SELECT s", Student.class);
        return theQuery.getResultList();
    }
}
