package com.kakuritsu.demo.cruddemo.entities;

import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
   
    public Course(){};

    public Course(String title) {
        this.title = title;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="title" , unique = true)
    private String title;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name ="instructor_id")
    private Instructor instructor;

     @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
     @JoinColumn(name = "course_id")
     private List<Review> reviews;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "course_student",
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;

     public void addReview(Review tempReview){
         if(reviews==null){
             reviews= new ArrayList<>();
         }
         reviews.add(tempReview);
     }
public void addStudent(Student student){
         if(students==null){
             students = new ArrayList<>();
         }
         students.add(student);
}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
//                ", instructor=" + instructor +
//                ", reviews=" + reviews +
//                ", students=" + students +
                '}';
    }
}
