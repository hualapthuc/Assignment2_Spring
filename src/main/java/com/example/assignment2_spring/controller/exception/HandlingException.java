package com.example.assignment2_spring.controller.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlingException {
    @ExceptionHandler(UnauthorizedException.class)
    public String handleError(Model model, Exception ex) {
        model.addAttribute("url", "");
        model.addAttribute("exception", ex);
        return "error";
    }
}
