package com.robn.cruddemo.dao;

import com.robn.cruddemo.entity.Course;
import com.robn.cruddemo.entity.Instructor;
import com.robn.cruddemo.entity.InstructorDetail;
import com.robn.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {
    private final EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(Integer id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(Integer id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        List<Course> courses = instructor.getCourses();

        for (Course course : courses) {
            // Break the association with the instructor
            course.setInstructor(null);
        }

        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(Integer id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(Integer id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        //Remove the associciated object reference
        //to break the bidirectional relationship
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(Integer instructorId) {
        TypedQuery<Course> query = entityManager.createQuery("FROM Course WHERE instructor.id = :instructorId", Course.class);
        query.setParameter("instructorId", instructorId);
        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(Integer id) {
        TypedQuery<Instructor> query = entityManager.createQuery("SELECT i FROM Instructor i " +
                "JOIN FETCH i.courses " +
                "JOIN FETCH i.instructorDetail " +
                "WHERE i.id = :id", Instructor.class);
        query.setParameter("id", id);
        Instructor instructor = query.getSingleResult();

        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(Integer id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void deleteCourseById(Integer id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(Integer id) {
        TypedQuery<Course> query = entityManager.createQuery("SELECT c FROM Course c " +
                "JOIN FETCH c.reviews " +
                "WHERE c.id = :courseId", Course.class);
        query.setParameter("courseId", id);
        Course course = query.getSingleResult();

        return course;
    }

    @Override
    public Course findCourseAndStudentsByCourseId(Integer id) {
        TypedQuery<Course> query = entityManager.createQuery("SELECT c FROM Course c " +
                "JOIN FETCH c.students " +
                "WHERE c.id = :courseId", Course.class);
        query.setParameter("courseId", id);
        Course course = query.getSingleResult();

        return course;
    }

    @Override
    public Student findStudentAndCoursesByStudentId(Integer id) {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s " +
                "JOIN FETCH s.courses " +
                "WHERE s.id = :studentId", Student.class);
        query.setParameter("studentId", id);
        Student student = query.getSingleResult();

        return student;
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(Integer id) {
        Student student = entityManager.find(Student.class, id);

        if (student != null) {
            List<Course> courses = student.getCourses();

            for (Course course : courses) {
                // Break the association with the student
                course.getStudents().remove(student);
            }

            entityManager.remove(student);
        }
    }
}
