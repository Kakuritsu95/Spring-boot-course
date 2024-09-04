package com.kakuritsu.cruddemo.interfaces;

import com.kakuritsu.cruddemo.entity.Student;

import java.util.ArrayList;
import java.util.List;

public interface IStudentDao {
    public void save(Student student);

    public Student findById(Integer id);

    public List<Student> findAllWhosFirstNameStartsWithParam(String firstNameParam);

    public void update(Student student);

    public void deleteStudent(Integer id);

    public int deleteAllStudents();
}
