package com.kakuritsu.demo.cruddemo.dao;

import com.kakuritsu.demo.cruddemo.entities.Course;
import com.kakuritsu.demo.cruddemo.entities.Instructor;
import com.kakuritsu.demo.cruddemo.entities.InstructorDetails;
import com.kakuritsu.demo.cruddemo.entities.Student;
import jakarta.persistence.EntityManager;

import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;


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

    public void delete(Instructor instructor) {
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetails findInstructorDetailsById(int id){
        return entityManager.find(InstructorDetails.class,id);

    }
    @Override

    public void deleteInstructorDetails(int id) {
        InstructorDetails tempInstructorDetails = this.findInstructorDetailsById(id);
        tempInstructorDetails.getInstructor().setInstructorDetails(null);
          entityManager.remove(tempInstructorDetails);
    }

    @Override
    public void saveCourse(Course course){
        entityManager.merge(course);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id){
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data", id);
        return query.getResultList();
    }


    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i JOIN FETCH i.courses where i.id = :data",Instructor.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }
    @Override
    public Course findCourseById(int id){
       return  entityManager.find(Course.class,id);
    };
    @Override

    public void deleteInstructorById(int id){
        Instructor instructor = entityManager.find(Instructor.class,id);
        List<Course> courses = instructor.getCourses();
        for(Course course : courses){
            course.setInstructor(null);
        }
        instructor.getInstructorDetails().setInstructor(null);

        entityManager.remove(instructor);
    }

    @Override
    public void deleteCourseById(int id){
    Course tempCourse = this.findCourseById(id);
    entityManager.remove(tempCourse);
    }

    @Override
    public Course findCourseByIdJoinFetch(int id){
        TypedQuery<Course> theQuery = entityManager.createQuery("select c from Course c JOIN FETCH c.reviews where c.id = :data",Course.class);
        theQuery.setParameter("data", id);
        return theQuery.getSingleResult();
    }

    @Override
    public void saveStudent(Student student){
        entityManager.merge(student);
    }

}
