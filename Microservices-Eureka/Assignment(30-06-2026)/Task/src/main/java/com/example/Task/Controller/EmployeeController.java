package com.example.Task.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Task.Service.EmployeeService;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public String getEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/raise-salary")
    public String raiseSalary(@RequestParam Long id, @RequestParam double incInSalary) {
        return employeeService.updateSalary(id, incInSalary);
    }
}