package com.example.Task.ExceptionHandling.Exceptions;

public class WrongDesignationInputException extends RuntimeException {
    public WrongDesignationInputException(String message) {
        super(message);
    }
}
