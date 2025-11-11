package com.example.gicws2.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllExceptions(Exception ex) {
        return new ResponseEntity<>("Global Error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Handle specific type
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleArithmeticException(ArithmeticException ex) {
        return new ResponseEntity<>("Math Error: Division by zero!", HttpStatus.BAD_REQUEST);
    }
}
