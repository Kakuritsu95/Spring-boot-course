package com.kakuritsu.cruddemo.dao;

import com.kakuritsu.cruddemo.entity.Student;
import com.kakuritsu.cruddemo.interfaces.IStudentDao;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class StudentDaoImpl implements IStudentDao {
    //Define field for entity manager
    private EntityManager entityManager;
    //Inject entity manager using constructor injection
    @Autowired
    public  StudentDaoImpl(EntityManager theEntityManager) {
        this.entityManager=theEntityManager;
    }
    //implement save method
    @Transactional
    @Override
    public void save(Student tempStudent){
        entityManager.persist(tempStudent);
    }

    @Override
    public Student findById(int integer){
        return entityManager.find(Student.class, integer);
    }

}
