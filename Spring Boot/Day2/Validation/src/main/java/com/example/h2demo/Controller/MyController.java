package com.example.h2demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.h2demo.Model.Student;
import com.example.h2demo.Service.StudentService;

import jakarta.validation.Valid;

@RestController
public class MyController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }
    @PostMapping("/add")
    public String addStudent(@Valid @RequestBody Student student) {
        return studentService.addStudent(student);
    }
}
