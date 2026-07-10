package com.example.Task.ExceptionHandling.Exceptions;

public class InvalidSalaryRaiseException extends RuntimeException{
    public InvalidSalaryRaiseException(String message) {
        super(message);
    }
}
