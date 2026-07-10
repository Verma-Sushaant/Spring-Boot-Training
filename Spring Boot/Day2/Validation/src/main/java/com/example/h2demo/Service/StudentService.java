package com.example.h2demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.h2demo.Exception.StudentNotFoundException;
import com.example.h2demo.Model.Student;
import com.example.h2demo.Repository.StudentRepo;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public String addStudent(@RequestBody Student student) {
        studentRepo.save(student);
        return "Student added successfully";
    }
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }
    public Student getStudentById(int id) {
        return studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student with id: "+id+" doesn't exist"));
    }
}
