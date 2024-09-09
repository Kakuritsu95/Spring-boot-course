package com.kakuritsu.simpleRestAPI.rest;

import com.kakuritsu.simpleRestAPI.entity.Student;
import com.kakuritsu.simpleRestAPI.service.StudentImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {

    private List<Student> theStudents;
    private StudentImpl studentService;

    DemoRestController(StudentImpl studentImpl){
        this.studentService = studentImpl;
    }

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("thod", "christof","kaku@gmail.com"));
        theStudents.add(new Student("mak", "elios","kaku@gmail.com"));
        theStudents.add(new Student("giannis", "giannakis","kaku@gmail.com"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {

        return theStudents;
    }
    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
     Student tempStudent =  studentService.getById(studentId);
     if(tempStudent==null) throw new StudentNotFoundException("Student id not found " + studentId);
     return tempStudent;
    }
    @GetMapping("/students/all")
    public List<Student> getTheStudents(){
        return studentService.getAllStudents();
    }
    @PostMapping("/students/create")
    public void createStudent(@RequestBody Student tempStudent){

     studentService.createStudent(tempStudent);

    }
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
//        StudentErrorResponse error = new StudentErrorResponse();
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//        error.setMessage(exc.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
//    }
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
//        StudentErrorResponse error = new StudentErrorResponse();
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.setMessage(exc.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
//    }
}
