package com.nautiDevelopers.Controller;

import com.nautiDevelopers.Entity.Student;
import com.nautiDevelopers.Exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/api") //Base URL
public class StudentController {

    //Creating Student Data
    private List<Student> student;
    @PostConstruct //To Load the Student Data only once.
    public void Load() {
        student = new ArrayList<>();
        student.add(new Student(1, "Akshit", "Nautiyal"));
        student.add(new Student(2, "Saurab", "Negi"));
        student.add(new Student(3, "Gopal", "Agarwal"));
    }

    @GetMapping("/students")
    public List<Student> getStudent() {
        return student;
    }

    // define endpoint for "/students/{id}" - return student at index
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable("id") int studentId){
        // check the studentId against list size
        if ( (studentId >= student.size()) || (studentId < 0) ){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return student.get(studentId); //student.get(int index) is method of ArrayList
    }
}
// BEST Practice




