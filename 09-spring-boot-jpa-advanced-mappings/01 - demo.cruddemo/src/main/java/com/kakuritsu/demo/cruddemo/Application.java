package com.kakuritsu.demo.cruddemo;

import com.kakuritsu.demo.cruddemo.dao.InstructorDao;
import com.kakuritsu.demo.cruddemo.entities.Course;
import com.kakuritsu.demo.cruddemo.entities.Instructor;
import com.kakuritsu.demo.cruddemo.entities.InstructorDetails;
import com.kakuritsu.demo.cruddemo.entities.Review;
import com.kakuritsu.demo.cruddemo.services.InstructorService;
import jakarta.persistence.EntityManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
			Instructor tempInstructor = new Instructor(
					"Thodorman",
					"Mparoufakis",
					"example@gmail.com"
			);

			InstructorDetails instructorDetails = new InstructorDetails("www.youtube.com/kingAlexGr","games");
			Course course1 = new Course("Megala vyza");
			Course course2 = new Course("Pws na nikiseis ton megalo drako");

			List<Course> courses = new ArrayList<>();
			tempInstructor.add(course1);
			tempInstructor.add(course2);
            course2.addReview(new Review("so nice course hehe xD"));
			tempInstructor.setInstructorDetails(instructorDetails);

			instructorService.save(tempInstructor);
			instructorService.deleteCourseById(2);

//			List<Course> coursesChanged = instructorService.findCoursesByInstructorId(1).stream().map(c-> {
//				 c.setTitle(c.getTitle()+new Random().nextInt());
//				 return c;
//			}).toList();
//			tempInstructor.setCourses(coursesChanged);
//			instructorService.save(tempInstructor);

//			Course course = instructorService.findCourseById(1);
//			course.setTitle("heheXD");
//			instructorService.updateCourse(course);
//
//			Instructor updatedInstructor = instructorService.findInstructorByIdJoinFetch(1);
//			System.out.println(updatedInstructor);
//
//			Instructor instr = instructorService.findById(1);
//			List<Course> someCoursesToAppend = instructorService.findCoursesByInstructorId(1);
//			instr.setCourses(someCoursesToAppend);
//			System.out.println(instr);
//			instructorService.deleteInstructorById(1);
			instructorService.deleteCourseById(1);

//			System.out.println(instructorService.findInstructorByIdJoinFetch(1));
//			Instructor tempInstructorLazy = instructorService.findInstructorByIdJoinFetch(1);
//            tempInstructorLazy.setEmail("LOL");
//			instructorService.save(tempInstructorLazy);
//			tempInstructorLazy.setCourses(null);
//			Instructor theInstructor = instructorService.findById(1);
//            theInstructor.getInstructorDetails().setHobby("running it down in league of legends");
//			List<Course> courses1 = instructorService.findCoursesByInstructorId(1).stream().peek(course->course.setTitle("asd")).toList();
//			theInstructor.setCourses(courses1);
//			instructorService.save(tempInstructor);
//			Instructor instructorJoinFetchLazy = instructorService.findInstructorByIdJoinFetch(1);
//			Instructor instructorJoinFetchLazy = instructorService.findById(1);

//			System.out.println(theInstructor);
//			instructorService.deleteInstructorDetailsById(1);

//			System.out.println(instructorService.findById(1));
//			InstructorDetails details = instructorService.findInstructorDetailsById(1);
//			System.out.println(details.getInstructor());
//			instructorService.deleteById(1);
//			System.out.println(instructorService.findById(1));

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
