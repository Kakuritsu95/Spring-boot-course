package com.kakuritsu.cruddemo.dao;

import com.kakuritsu.cruddemo.entity.Student;
import com.kakuritsu.cruddemo.interfaces.IStudentDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Student findById(Integer id){
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAllWhosFirstNameStartsWithParam(String firstNameParam){
     TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student s WHERE s.firstName LIKE :firstNameParam order by lastName" , Student.class);
     theQuery.setParameter("firstNameParam", firstNameParam + "%");

     return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student){

        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id){
        Student tempStudent = entityManager.find(Student.class,id);
        entityManager.remove(tempStudent);
    }

    @Override
    @Transactional
    public int deleteAllStudents() {
        Query theQuery = entityManager.createQuery("DELETE FROM Student");
        return theQuery.executeUpdate();

    }

}
