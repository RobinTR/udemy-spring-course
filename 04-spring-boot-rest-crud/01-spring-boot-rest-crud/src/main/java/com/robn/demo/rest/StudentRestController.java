package com.robn.demo.rest;

import com.robn.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students = new ArrayList<Student>();

    @PostConstruct
    public void loadData() {
        students.add(new Student("Poornima", "Patel"));
        students.add(new Student("Mario", "Rossi"));
        students.add(new Student("Marry", "Dan"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        //Spring Jackson Data Binding is automatically done.
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        //Index of the list. Simple approach for now.
        return students.get(studentId);
    }
}
