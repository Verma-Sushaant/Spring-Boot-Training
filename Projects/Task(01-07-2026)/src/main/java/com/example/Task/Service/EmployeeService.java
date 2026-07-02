package com.example.Task.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Task.Entity.Employee;
import com.example.Task.Exception.AgeOutOfRangeException;
import com.example.Task.Exception.EmployeeNotFoundException;
import com.example.Task.Repository.EmployeeRepo;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public String addEmployee(Employee employee) {
        int ageCheck = Integer.parseInt(employee.getAge());
        if(ageCheck < 18 || ageCheck > 60) {
            throw new AgeOutOfRangeException("Age must be between 18 and 60");
        }
        employeeRepo.save(new Employee(employee.getName(), employee.getAge(), employee.getDesignation()));
        return "Employee added successfully";
    }
    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }
    public Employee updateSalary(String name, double percent) {
        Employee emp = employeeRepo.findByName(name).orElseThrow(() -> new EmployeeNotFoundException(name+" not found"));
        double salary = emp.getSalary()*(percent/100);
        emp.setSalary(emp.getSalary()+salary);
        employeeRepo.save(emp);
        return emp;
    }
}
