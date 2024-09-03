package com.kakuritsu.cruddemo;

import com.kakuritsu.cruddemo.dao.StudentDaoImpl;
import com.kakuritsu.cruddemo.entity.Student;
import com.kakuritsu.cruddemo.interfaces.IStudentDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(IStudentDao studentDao) {

		return runner-> {

//			createStudent(studentDao);
//			createMultipleStudents(studentDao);
			Student studentWithId4 =  getStudentById(studentDao,20);
			System.out.println(studentWithId4);
		};

	}

	private void createMultipleStudents(IStudentDao studentDao) {

		//create multiple students
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("Morgan","Freeman","morgfree@hotmail.com");
		Student tempStudent2 = new Student("Kaku","Ritsu","ritsos@hotmail.com");
		Student tempStudent3 = new Student("Donald","Duck","DD@gmail.com");
		//save the student objects
		System.out.println("Saving the students");
		studentDao.save(tempStudent1);
		studentDao.save(tempStudent2);
		studentDao.save(tempStudent3);


		}



	private void createStudent(IStudentDao studentDao){

		// create the student object
		System.out.println("Creating new student...");
		Student tempStudent = new Student("Tho","Doris","daroricklineage2@hotmail.com");

        // save the student object
		System.out.println("Saving user in db...");
		studentDao.save(tempStudent);

        // display the saved students id
		System.out.println("Student saved with id " + tempStudent.getId());

	}

	private Student getStudentById(IStudentDao studentDao, int id){
		return studentDao.findById(id);
	}
}
