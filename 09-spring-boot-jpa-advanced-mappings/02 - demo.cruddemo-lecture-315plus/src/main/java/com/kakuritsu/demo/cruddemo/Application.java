package com.kakuritsu.demo.cruddemo;


import com.kakuritsu.demo.cruddemo.entities.Course;
import com.kakuritsu.demo.cruddemo.entities.Instructor;

import com.kakuritsu.demo.cruddemo.entities.Review;
import com.kakuritsu.demo.cruddemo.entities.Student;
import com.kakuritsu.demo.cruddemo.services.InstructorService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;


import java.util.List;


@SpringBootApplication
public class Application {
private final InstructorService instructorService;
	Application(InstructorService instructorService){
		this.instructorService=instructorService;

	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean

	public CommandLineRunner commandLineRunner(String[] args){

		return runner-> {
			System.out.println("Hello World");
           Course createdCourse = new Course("Hibernate relational mappings");
			Student student1 = new Student("papas", "papakis", "papaki@papaki.com");
		   instructorService.saveCourse(createdCourse);
           Course course = instructorService.findCourseById(1);
		   course.setReviews(null);
			course.setStudents(null);
            course.addStudent(student1);

		   Review review1 = new Review("Excellent Course");
		   Review review2 = new Review("That helped me a lot");
		   Review review3 = new Review("NO SENSE! BAD BAD BAD!");
		   course.addReview(review1);
		   course.addReview(review2);
		   course.addReview(review3);
		   instructorService.saveCourse(course);
           System.out.println(instructorService.findCourseByIdJoinFetchReviews(1).getReviews());
		   instructorService.deleteCourseById(1);
//		   instructorService.deleteCourseById(1);
		};


	}
    private void findCoursesForInstructor(int id){
		Instructor tempInstructor = instructorService.findById(id);
		List<Course>courses = instructorService.findCoursesByInstructorId(id);
		tempInstructor.setCourses(courses);
	}
	private Instructor findInstructorWithCourse(int id){
	   Instructor tempInstructor =  instructorService.findById(id);
	   System.out.println("Found instructor with id of " + id);
	   System.out.println("Associated with courses " + tempInstructor.getCourses());

	   System.out.println("Done");
	   return tempInstructor;
	}
	private InstructorDTO instructorEntityToDto(Instructor instructor){
		return new InstructorDTO(instructor.getFirstname(),instructor.getLastname());
	}
}
