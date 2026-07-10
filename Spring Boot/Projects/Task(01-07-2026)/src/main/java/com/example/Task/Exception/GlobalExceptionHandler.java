package com.example.Task.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public String handleEmployeeNotFound(EmployeeNotFoundException ex) {
        return ex.getMessage();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            errors.put(error.getField(), error.getDefaultMessage())
        );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidSalaryRaiseException.class)
    public String handleSalaryRaiseException(InvalidSalaryRaiseException ex) {
        return ex.getMessage();
    }
    @ExceptionHandler(WrongDesignationInputException.class)
    public String handleDesignationException(WrongDesignationInputException ex) {
        return ex.getMessage();
    }
}
