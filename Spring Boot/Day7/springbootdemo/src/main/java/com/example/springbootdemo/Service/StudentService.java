package com.example.springbootdemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootdemo.Entity.Student;
import com.example.springbootdemo.Repository.StudentRepo;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public String addStudent(Student student) {
        studentRepo.save(student);
        return "Employee added successfully";
    }

    public List<Student> fetchStudents() {
        return studentRepo.findAll();
    }

    public String fetchStudentById(int id) {
        return studentRepo.findById(id).get().toString();
    }

    public String deleteStudentById(int id) {
        studentRepo.deleteById(id);
        return "Student with id: "+id+" deleted.";
    }

    public String updateCGPA(int id, double cgpa) {
        Student stud = studentRepo.findById(id).get();
        stud.setCgpa(cgpa);
        studentRepo.save(stud);
        return stud.toString();
    }
}
