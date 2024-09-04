package com.kakuritsu.cruddemo;

import com.kakuritsu.cruddemo.dao.StudentDaoImpl;
import com.kakuritsu.cruddemo.entity.Student;
import com.kakuritsu.cruddemo.interfaces.IStudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	@Autowired
	public CommandLineRunner commandLineRunner(IStudentDao studentDao) {

		return runner-> {

//			createStudent(studentDao);
			createMultipleStudents(studentDao);
//			Student studentWithId4 =  getStudentById(studentDao,20);
//			System.out.println(studentWithId4);
//			System.out.println(this.getAllStudentsWhosFirstNameStartsWith(studentDao,"M"));
//			for(Student tempStudent: this.getAllStudentsWhosFirstNameStartsWith(studentDao,"John")){
//				System.out.println(tempStudent);
//			}
//			Student tempStudent = studentDao.findById(3);
//			tempStudent.setLastName("New Newman");
//			studentDao.update(tempStudent);
//
//			System.out.println(studentDao.findById(3));
//			
//			System.out.print(studentDao.findById(2));
//			studentDao.deleteStudent(2);
//			System.out.print(studentDao.findById(2));
////
//          Delete all students
//			int numberOfDeletedStudents = studentDao.deleteAllStudents();



		};

	}

	private void createMultipleStudents(IStudentDao studentDao) {

		//create multiple students
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("Bilbo","Jenkins","bilb@hotmail.com");
		Student tempStudent2 = new Student("Manos","Papakaliatis","manospap@hotmail.com");
		Student tempStudent3 = new Student("Bringit","On","bringiton@gmail.com");
		//save the student objects
		System.out.println("Saving the students");
		studentDao.save(tempStudent1);
		studentDao.save(tempStudent2);
		studentDao.save(tempStudent3);


		}



	private void createStudent(IStudentDao studentDao){

		// create the student object
		System.out.println("Creating new student...");
		Student tempStudent = new Student("Mitsos","Xatzhs","mits@hotmail.com");

        // save the student object
		System.out.println("Saving user in db...");
		studentDao.save(tempStudent);

        // display the saved students id
		System.out.println("Student saved with id " + tempStudent.getId());

	}

	private Student getStudentById(IStudentDao studentDao, Integer id){
		return studentDao.findById(id);
	}

	private List<Student> getAllStudentsWhosFirstNameStartsWith(IStudentDao studentDao,String firstNameParam){
		return studentDao.findAllWhosFirstNameStartsWithParam(firstNameParam);
	}
}
