package com.kakuritsu.demo.cruddemo.dao;

import com.kakuritsu.demo.cruddemo.entities.Instructor;
import com.kakuritsu.demo.cruddemo.entities.InstructorDetails;

public interface InstructorDao {
    public Instructor findById(int id);

    public void save(Instructor instructor);

    public void deleteById(Instructor instructor);

    public InstructorDetails findInstructorDetailsById(int id);

}
