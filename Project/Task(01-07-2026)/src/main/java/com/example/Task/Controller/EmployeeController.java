package com.example.Task.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Task.Entity.Employee;
import com.example.Task.Service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping("/add-employee")
    public String addEmployee(@RequestBody @Valid Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PostMapping("/raise-salary")
    public Employee raiseSalary(
        @RequestParam String name,
        @RequestParam double percent
    ) {
        return employeeService.updateSalary(name, percent);
    }
}
