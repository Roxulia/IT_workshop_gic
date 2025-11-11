package com.example.gicws2.demo.Controllers;

import com.example.gicws2.demo.Services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/number5")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test-exception")
    public String testException() {
        // This will throw an ArithmeticException
        int x = 10 / 0;
        return "Result: " + x;
    }

    @GetMapping("/test-aspect")
    public String testAspect() {
        return testService.performTask();
    }

}
