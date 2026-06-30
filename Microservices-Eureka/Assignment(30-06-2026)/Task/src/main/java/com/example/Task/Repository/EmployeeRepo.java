package com.example.Task.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Task.Entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
    
}