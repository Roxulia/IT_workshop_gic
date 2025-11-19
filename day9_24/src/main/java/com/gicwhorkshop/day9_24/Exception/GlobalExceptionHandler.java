package com.gicwhorkshop.day9_24.Exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle all exceptions
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error"; // error.html Thymeleaf template
    }

    // Handle specific exception
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgument(IllegalArgumentException ex, Model model) {
        model.addAttribute("errorMessage", "Invalid input: " + ex.getMessage());
        return "error";
    }
}

