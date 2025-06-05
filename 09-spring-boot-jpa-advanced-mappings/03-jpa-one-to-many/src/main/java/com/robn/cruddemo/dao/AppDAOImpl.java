package com.robn.cruddemo.dao;

import com.robn.cruddemo.entity.Course;
import com.robn.cruddemo.entity.Instructor;
import com.robn.cruddemo.entity.InstructorDetail;
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
}
