package com.example.demo.exceptions;

public class UserRegistrationException extends RuntimeException {
    public UserRegistrationException(String message) {
        super(message);
    }
}
