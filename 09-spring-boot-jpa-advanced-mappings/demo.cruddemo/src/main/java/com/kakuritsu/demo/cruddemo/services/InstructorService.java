package com.kakuritsu.demo.cruddemo.services;

import com.kakuritsu.demo.cruddemo.entities.Instructor;
import com.kakuritsu.demo.cruddemo.entities.InstructorDetails;


public interface InstructorService {
    public Instructor findById(int id);

    public void save(Instructor instructor);

    public void deleteById(int id);

    public InstructorDetails findInstructorDetailsById(int id);
}
