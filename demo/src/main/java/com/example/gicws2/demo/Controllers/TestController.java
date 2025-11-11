package com.example.gicws2.demo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/number5")
public class TestController {
    @GetMapping("/test")
    public String testException() {
        // This will throw an ArithmeticException
        int x = 10 / 0;
        return "Result: " + x;
    }
}
