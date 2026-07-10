package com.example.h2demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private StudentRepo studRepo;
    @GetMapping("/students")
    public List<Student> getStudents() {
        return studRepo.findAll();
    }
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        studRepo.save(student);
        return "Student added successfully";
    }
}
