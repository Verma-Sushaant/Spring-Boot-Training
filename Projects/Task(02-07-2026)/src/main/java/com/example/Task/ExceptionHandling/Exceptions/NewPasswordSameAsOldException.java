package com.example.Task.ExceptionHandling.Exceptions;

public class NewPasswordSameAsOldException extends RuntimeException {
    public NewPasswordSameAsOldException(String message) {
        super(message);
    }
}
