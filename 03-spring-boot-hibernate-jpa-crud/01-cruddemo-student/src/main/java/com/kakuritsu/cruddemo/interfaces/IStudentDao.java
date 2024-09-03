package com.kakuritsu.cruddemo.interfaces;

import com.kakuritsu.cruddemo.entity.Student;

import java.util.ArrayList;

public interface IStudentDao {
    public void save(Student student);

    public Student findById(int integer);
}
