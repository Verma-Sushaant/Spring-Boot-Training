package com.example.h2demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.h2demo.Model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{
    
}
