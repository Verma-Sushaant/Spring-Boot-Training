package com.example.Task.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Task.Entity.Employee;
import com.example.Task.Repository.EmployeeRepo;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public String getAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        return employees.stream()
                    .map(Employee::toString)
                    .collect(Collectors.joining("\n"));
    }

    public String updateSalary(Long id, double incInSalary) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee Not Found"));
        employee.raiseSalary(incInSalary);
        employeeRepo.save(employee);
        return employee.toString();
    }
}