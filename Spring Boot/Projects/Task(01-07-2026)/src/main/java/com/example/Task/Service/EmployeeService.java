package com.example.Task.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Task.Entity.Employee;
import com.example.Task.Exception.EmployeeNotFoundException;
import com.example.Task.Exception.InvalidSalaryRaiseException;
import com.example.Task.Exception.WrongDesignationInputException;
import com.example.Task.Repository.EmployeeRepo;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public String addEmployee(Employee employee) {
        String designation = employee.getDesignation();
        if(!designation.equalsIgnoreCase("programmer") 
            && !designation.equalsIgnoreCase("manager") 
            && !designation.equalsIgnoreCase("tester")) {
            throw new WrongDesignationInputException("Designation can be \"Programmer\", \"Manager\", \"Tester\"");
        }
        employeeRepo.save(new Employee(employee.getName(), employee.getAge(), employee.getDesignation()));
        return "Employee added successfully";
    }
    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }
    public Employee updateSalary(String name, double percent) {
        if(percent > 10 || percent < 1) throw new InvalidSalaryRaiseException("Raise percent should be in 1 - 10.");
        Employee emp = employeeRepo.findByName(name).orElseThrow(() -> new EmployeeNotFoundException(name+" not found."));
        double salary = emp.getSalary()*(percent/100);
        emp.setSalary(emp.getSalary()+salary);
        employeeRepo.save(emp);
        return emp;
    }
}
