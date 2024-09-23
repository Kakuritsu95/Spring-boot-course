package com.kakuritsu.demo.cruddemo.dao;

import com.kakuritsu.demo.cruddemo.entities.Instructor;
import com.kakuritsu.demo.cruddemo.entities.InstructorDetails;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public class InstructorDaoImpl implements InstructorDao{
     private final EntityManager entityManager;
    public InstructorDaoImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public Instructor findById(int id) {
       return entityManager.find(Instructor.class,id);
    }

    @Override
    public void save(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    public void deleteById(Instructor instructor) {
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetails findInstructorDetailsById(int id){
        return entityManager.find(InstructorDetails.class,id);

    }
}
