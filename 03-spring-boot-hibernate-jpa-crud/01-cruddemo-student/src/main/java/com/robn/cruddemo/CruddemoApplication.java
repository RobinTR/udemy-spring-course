package com.robn.cruddemo;

import com.robn.cruddemo.dao.StudentDAO;
import com.robn.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			queryForStudentsByLastName(studentDAO);
		};
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Doe");

		for(Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student student = new Student("Robin", "Cen", "memrobincen@gmail.com");
		studentDAO.save(student);
		int id = student.getId();
		Student myStudent = studentDAO.findById(id);
		System.out.println(myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		Student student1 = new Student("John", "Doe", "john@john.com");
		Student student2 = new Student("Brian", "Doe", "brian@brian.com");
		Student student3 = new Student("Mary", "Doe", "mary@mary.com");

		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating student...");
		Student student = new Student("Paul", "Doe", "paul@paul.com");

		System.out.println("Saving the student...");
		studentDAO.save(student);

		System.out.println("Saved student Id: " + student.getId());
	}
}
