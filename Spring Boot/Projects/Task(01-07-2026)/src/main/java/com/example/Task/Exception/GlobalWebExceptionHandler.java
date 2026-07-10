package com.example.Task.Exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.Task.Entity.Employee;

@ControllerAdvice
public class GlobalWebExceptionHandler {

    @ExceptionHandler(WrongDesignationInputException.class)
    public String handleDesignationException(WrongDesignationInputException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        model.addAttribute("employee", new Employee());
        return "add-employee";
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public String handleEmployeeNotFound(EmployeeNotFoundException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        model.addAttribute("employees", java.util.Collections.emptyList());
        return "employees";
    }

    @ExceptionHandler(InvalidSalaryRaiseException.class)
    public String handleInvalidRaise(InvalidSalaryRaiseException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "employees";
    }

    @ExceptionHandler(Exception.class)
    public String handleGenericException(Exception ex, Model model) {
        model.addAttribute("errorMessage", "Something went wrong: " + ex.getMessage());
        model.addAttribute("employee", new Employee());
        return "add-employee";
    }
}
