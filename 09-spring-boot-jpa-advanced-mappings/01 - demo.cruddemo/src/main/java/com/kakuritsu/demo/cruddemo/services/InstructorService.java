package com.kakuritsu.demo.cruddemo.services;

import com.kakuritsu.demo.cruddemo.entities.Course;
import com.kakuritsu.demo.cruddemo.entities.Instructor;
import com.kakuritsu.demo.cruddemo.entities.InstructorDetails;

import java.util.List;


public interface InstructorService {
    public Instructor findById(int id);

    public void save(Instructor instructor);

    public void deleteById(int id);

    public InstructorDetails findInstructorDetailsById(int id);

    public void deleteInstructorDetailsById(int id);

    public void saveCourse(Course course);

    public List<Course> findCoursesByInstructorId(int id);

    public Instructor findInstructorByIdJoinFetch(int id);

    public void updateCourse(Course course);

    public Course findCourseById(int id);

    public void deleteInstructorById(int id);

    public void deleteCourseById(int id);

}

