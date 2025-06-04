package com.robn.cruddemo;

import com.robn.cruddemo.dao.AppDAO;
import com.robn.cruddemo.entity.Instructor;
import com.robn.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			createInstructor(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO) {
		/*
		Instructor instructor = new Instructor("Chad", "Darby", "darby@darby.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "Loving the Spring Framework");
		 */
		Instructor instructor = new Instructor("Robin", "Çen", "robn@robn.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "Loving the Spring Framework");
		instructor.setInstructorDetail(instructorDetail);

		//This will also save the details object because of CascadeType.ALL
		appDAO.save(instructor);
		System.out.println("Saved Instructor: " + instructor);
	}

}
