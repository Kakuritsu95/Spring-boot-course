package com.kakuritsu.demo.cruddemo.dao;

import com.kakuritsu.demo.cruddemo.entities.Course;
import com.kakuritsu.demo.cruddemo.entities.Instructor;
import com.kakuritsu.demo.cruddemo.entities.InstructorDetails;
import com.kakuritsu.demo.cruddemo.entities.Student;

import java.util.List;

public interface InstructorDao {
    public Instructor findById(int id);

    public void save(Instructor instructor);

    public void delete(Instructor instructor);

    public InstructorDetails findInstructorDetailsById(int id);


    public void deleteInstructorDetails(int id);

//    public Course findCourseById(int id);

    public void saveCourse(Course course);

    public List<Course> findCoursesByInstructorId(int id);

    public Instructor findInstructorByIdJoinFetch(int id );

    public void updateCourse(Course course);

    public Course findCourseById(int id);

    public void deleteInstructorById(int id);

    public void deleteCourseById(int id);

    public Course findCourseByIdJoinFetch(int id);

    public void saveStudent(Student student);
}

