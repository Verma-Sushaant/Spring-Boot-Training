package com.example.springbootdemo.Controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootdemo.Entity.Student;
import com.example.springbootdemo.Service.StudentService;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add-student")
    public String addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/update-cgpa/{id}")
    public String updateCgpa(@PathVariable int id, @RequestBody double cgpa) {
        return studentService.updateCGPA(id, cgpa);
    }

    @DeleteMapping("/remove-student/{id}")
    public String deleteStudent(@PathVariable int id) {
        return studentService.deleteStudentById(id);
    }

    @GetMapping("/students")
    public String getStudents() {
        return studentService.fetchStudents().stream()
                            .map(Student::toString)
                            .collect(Collectors.joining("\n"));
    }

    @GetMapping("/student/{id}")
    public String getStudent(@PathVariable int id) {
        return studentService.fetchStudentById(id);
    }
}
