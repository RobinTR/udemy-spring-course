package com.robn.cruddemo.dao;

import com.robn.cruddemo.entity.Course;
import com.robn.cruddemo.entity.Instructor;
import com.robn.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(Integer id);
    void deleteInstructorById(Integer id);
    InstructorDetail findInstructorDetailById(Integer id);
    void deleteInstructorDetailById(Integer id);
    List<Course> findCoursesByInstructorId(Integer instructorId);
    Instructor findInstructorByIdJoinFetch(Integer id);
    void update(Instructor instructor);
    void update(Course course);
    Course findCourseById(Integer id);
    void deleteCourseById(Integer id);
}
