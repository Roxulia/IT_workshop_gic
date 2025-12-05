package com.gicws.day28.Config;

import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice  // Global exception handler
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public @ResponseBody String handleAll(Exception e) {
        e.printStackTrace();
        return "Global Exception: " + e.getMessage();
    }

//    @ExceptionHandler({ BindException.class, MethodArgumentNotValidException.class })
//    public String handleValidationExceptions(Exception ex, Model model) {
//        model.addAttribute("error", "Please fix the errors below");
//        return "registration"; // go back to the form
//    }
}
