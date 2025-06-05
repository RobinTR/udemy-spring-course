package com.robn.cruddemo;

import com.robn.cruddemo.dao.AppDAO;
import com.robn.cruddemo.entity.Course;
import com.robn.cruddemo.entity.Instructor;
import com.robn.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			//deleteInstructorDetail(appDAO);
			//createInstructorWithCourses(appDAO);
			//findInstructorWithCourses(appDAO);
			//findCoursesForInstructor(appDAO);
			//findInstructorWithCoursesJoinFetch(appDAO);
			//updateInstructor(appDAO);
			//updateCourse(appDAO);
			//deleteInstructor(appDAO);
			deleteCourse(appDAO);
		};
	}

	private void deleteCourse(AppDAO appDAO) {
		Integer id = 11;
		appDAO.deleteCourseById(id);
		System.out.println("Course deleted with ID: " + id);
	}

	private void updateCourse(AppDAO appDAO) {
		Integer id = 10;
		Course course = appDAO.findCourseById(id);
		course.setTitle(course.getTitle() + " updated");
		appDAO.update(course);
		System.out.println("Course updated");
	}

	private void updateInstructor(AppDAO appDAO) {
		Integer id = 1;
		Instructor instructor = appDAO.findInstructorById(id);
		instructor.setLastName("TEST");
		appDAO.update(instructor);
		System.out.println("Instructor updated");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		Integer id = 1;
		System.out.println("Finding instructor with ID: " + id);
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);
		System.out.println("Instructor: " + instructor);
		System.out.println("Associated Courses: " + instructor.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		Integer id = 1;
		System.out.println("Finding instructor with ID: " + id);
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Instructor: " + instructor);
		List<Course> courses = appDAO.findCoursesByInstructorId(id);
		instructor.setCourses(courses);
		System.out.println("Associated Courses: " + instructor.getCourses());
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		Integer id = 1;
		System.out.println("Finding instructor with ID: " + id);
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Instructor: " + instructor);
		System.out.println("Associated Courses: " + instructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor("Mem Robin", "Çen", "robn@robn.com");
		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com", "Video Games");
		instructor.setInstructorDetail(instructorDetail);
		Course course1 = new Course("Java Programming");
		Course course2 = new Course("C# Programming");
		instructor.addCourse(course1);
		instructor.addCourse(course2);
		appDAO.save(instructor);
		// This will also save the courses because of CascadeType.PERSIST
		System.out.println("Saved Instructor with Courses: " + instructor);
		System.out.println("Courses: " + instructor.getCourses());
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		Integer id = 3;
		System.out.println("Deleting instructor detail with ID: " + id);
		appDAO.deleteInstructorDetailById(id);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		Integer id = 2;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
		System.out.println("instructorDetail: " + instructorDetail);
		System.out.println("Associated Instructor: " + instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		Integer id = 1;
		appDAO.deleteInstructorById(id);
		System.out.println("Deleted instructor with ID: " + id);
	}

	private void findInstructor(AppDAO appDAO) {
		Integer instructorId = 1;
		System.out.println("Finding instructor with ID: " + instructorId);
		Instructor instructor = appDAO.findInstructorById(instructorId);
		System.out.println("Found Instructor: " + instructor);
		System.out.println("Associated Instructor Details only: " + instructor.getInstructorDetail());
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
