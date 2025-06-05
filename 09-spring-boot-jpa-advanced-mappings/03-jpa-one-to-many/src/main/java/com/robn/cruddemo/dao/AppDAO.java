package com.robn.cruddemo.dao;

import com.robn.cruddemo.entity.Instructor;
import com.robn.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(Integer id);
    void deleteInstructorById(Integer id);
    InstructorDetail findInstructorDetailById(Integer id);
    void deleteInstructorDetailById(Integer id);
}
