package com.kakuritsu.simpleRestAPI.service;

import com.kakuritsu.simpleRestAPI.entity.Student;

import java.util.List;

public interface IStudent {
    public Student getById(int id);

    public void createStudent(Student student);

    public List<Student> getAllStudents();
}
