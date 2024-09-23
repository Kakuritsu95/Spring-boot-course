package com.kakuritsu.demo.cruddemo.services;

import com.kakuritsu.demo.cruddemo.dao.InstructorDao;
import com.kakuritsu.demo.cruddemo.entities.Instructor;

import com.kakuritsu.demo.cruddemo.entities.InstructorDetails;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class InstructorServiceImpl implements InstructorService {

private final InstructorDao instructorDao;

public InstructorServiceImpl(InstructorDao theInstructorDao){
    instructorDao = theInstructorDao;
}

    @Override
    public Instructor findById(int id) {
        Optional<Instructor> result = Optional.ofNullable(instructorDao.findById(id));


        return result.orElseThrow(() -> new RuntimeException("Instructor not found with id: " + id));
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
      instructorDao.save(instructor);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
       Instructor instructorToDelete = this.findById(id);
       instructorDao.deleteById(instructorToDelete);
    }

    @Override
    public InstructorDetails findInstructorDetailsById(int id) {
     Optional<InstructorDetails> result = Optional.ofNullable(instructorDao.findInstructorDetailsById(id));
     return result.orElseThrow(()->new RuntimeException("InstructorDetails with id of " + id + " not found"));
    }
}
