package com.gicws.day27.Config;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice  // Global exception handler
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public @ResponseBody String handleAll(Exception e) {
        return "Global Exception: " + e.getMessage();
    }
}
