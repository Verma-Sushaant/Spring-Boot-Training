package com.example.Task.ExceptionHandling.Exceptions;

public class PasswordNotMatchException extends RuntimeException {
    public PasswordNotMatchException(String message) {
        super(message);
    }
}
