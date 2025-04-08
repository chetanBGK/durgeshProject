package com.userservice.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("Resource Not Found On Server !!");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
