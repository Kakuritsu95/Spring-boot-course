package com.kakuritsu.demo.cruddemo;

import com.kakuritsu.demo.cruddemo.dao.InstructorDao;
import com.kakuritsu.demo.cruddemo.entities.Instructor;
import com.kakuritsu.demo.cruddemo.entities.InstructorDetails;
import com.kakuritsu.demo.cruddemo.services.InstructorService;
import jakarta.persistence.EntityManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

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
			tempInstructor.setInstructorDetails(instructorDetails);
			instructorService.save(tempInstructor);
			System.out.println(instructorService.findById(1).toString());
			InstructorDetails details = instructorService.findInstructorDetailsById(1);
			System.out.println(details.getInstructor());

//			instructorService.deleteById(1);
			System.out.println(instructorService.findById(1));
		};
	}

}
