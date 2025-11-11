package com.example.gicws2.demo;

import com.example.gicws2.demo.Services.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AspectTest {

    @Autowired
    private TestService testService;

    @Test
    void testAspectLogsExecutionTime() {
        System.out.println("Running test...");
        String result = testService.performTask();
        System.out.println("Service result: " + result);
        // Check console logs for execution time output by aspect
    }
}
