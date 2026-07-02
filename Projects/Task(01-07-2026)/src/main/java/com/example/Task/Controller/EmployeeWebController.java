package com.example.Task.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Task.Entity.Employee;
import com.example.Task.Exception.WrongDesignationInputException;
import com.example.Task.Service.EmployeeService;

import jakarta.validation.Valid;

@Controller
public class EmployeeWebController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/add-employee-form")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add-employee";
    }

    @PostMapping("/employee-form")
    public String submitForm(@Valid @ModelAttribute("employee") Employee employee,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            // redisplay the form with field-specific errors
            return "add-employee";
        }
        try {
            employeeService.addEmployee(employee);
        } catch (WrongDesignationInputException e) {
            result.rejectValue("designation", "error.employee",e.getMessage());
            return "add-employee";
        }
        model.addAttribute("successMessage","Employee added successfully.");
        model.addAttribute("employee",new Employee());
        return "add-employee";
    }

    @GetMapping("/employees")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        return "employees"; // matches employees.html
    }

    @PostMapping("/raise-salary")
    public String raiseSalary(@RequestParam String name,
            @RequestParam double percent,
            Model model) {
        try {
            employeeService.updateSalary(name, percent);
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        // reload employee list
        model.addAttribute("employees", employeeService.getEmployees());
        return "employees";
    }

}
