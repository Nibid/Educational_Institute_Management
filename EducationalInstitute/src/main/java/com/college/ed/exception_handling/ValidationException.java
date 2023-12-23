package com.college.ed.exception_handling;

@SuppressWarnings("serial")
public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }
}
