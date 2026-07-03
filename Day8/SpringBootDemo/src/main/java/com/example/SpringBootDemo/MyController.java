package com.example.SpringBootDemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootDemo.model.Employee;

@RestController
public class MyController {
    List<Employee> emp = new ArrayList<>();
    public MyController() {
        emp.add(new Employee(1,"John",30,50000,"Developer"));
        emp.add(new Employee(2,"Jane",28,60000,"Tester"));
        emp.add(new Employee(3,"Modi",58,90000,"Manager"));
    }

    @GetMapping("/get-all-employees")
    public List<Employee> getEmployees() {
        return emp;
    }

    @GetMapping("/get-employee/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        for(Employee e: emp) {
            if(e.getId() == id) return e;
        }
        return null;
    }

    @PutMapping("/update-salary")
    public Employee updatEmployee(@RequestParam("ID") int id, @RequestParam("sal") int salary) {
        Employee employee = null;
        for(Employee e: emp) {
            if(e.getId() == id) employee = e;
        }
        if(employee == null) return employee;
        employee.setSalary(salary);
        return employee;
    }

    @DeleteMapping("delete-employee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = null;
        for(Employee e: emp) {
            if(e.getId() == id) employee = e;
        }
        if(employee == null) return "Employee with id: "+id+" not present.";
        emp.remove(emp.indexOf(employee));
        return "Employee with id: "+id+" deleted.";
    }
}
