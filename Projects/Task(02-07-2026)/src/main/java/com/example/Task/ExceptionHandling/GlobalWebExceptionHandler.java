package com.example.Task.ExceptionHandling;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.Task.Entity.Employee;
import com.example.Task.ExceptionHandling.Exceptions.EmployeeNotFoundException;
import com.example.Task.ExceptionHandling.Exceptions.IncorrectPasswordException;
import com.example.Task.ExceptionHandling.Exceptions.InvalidSalaryRaiseException;
import com.example.Task.ExceptionHandling.Exceptions.NewPasswordSameAsOldException;
import com.example.Task.ExceptionHandling.Exceptions.PasswordNotMatchException;
import com.example.Task.ExceptionHandling.Exceptions.UserPresentException;
import com.example.Task.ExceptionHandling.Exceptions.UsernameAlreadyTakenException;
import com.example.Task.ExceptionHandling.Exceptions.UsernameNotFoundException;
import com.example.Task.ExceptionHandling.Exceptions.WrongDesignationInputException;

@ControllerAdvice
public class GlobalWebExceptionHandler {

    // @ExceptionHandler(AgeOutOfRangeException.class)
    // public String handleAgeException(AgeOutOfRangeException ex, Model model) {
    //     model.addAttribute("errorMessage", ex.getMessage());
    //     model.addAttribute("employee", new Employee()); // rebind form
    //     return "add-employee";
    // }
    @ExceptionHandler(UsernameNotFoundException.class)
    public String handleUsernameNotFound(UsernameNotFoundException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "login";
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    public String handleWrongPassword(IncorrectPasswordException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "login";
    }

    @ExceptionHandler(UserPresentException.class)
    public String handleUserPresentRegistering(UserPresentException ex, Model model) {
        model.addAttribute("errorMessage",ex.getMessage());
        return "register";
    }

    @ExceptionHandler(UsernameAlreadyTakenException.class)
    public String handleUsernameAlreadyTaken(UsernameAlreadyTakenException ex, Model model) {
        model.addAttribute("errorMessage",ex.getMessage());
        return "register";
    }

    @ExceptionHandler(PasswordNotMatchException.class)
    public String handlePasswordNotMatch(PasswordNotMatchException ex, Model model) {
        model.addAttribute("errorMessage",ex.getMessage());
        return "register";
    }

    @ExceptionHandler(NewPasswordSameAsOldException.class)
    public String handleNewPasswordSameAsOld(NewPasswordSameAsOldException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "forgot-password";
    }

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
