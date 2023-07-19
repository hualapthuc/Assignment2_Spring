package com.example.assignment2_spring.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "User not logged in") //401
public class UnauthorizedException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UnauthorizedException(String message) {
        super(message);
    }

    public UnauthorizedException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
