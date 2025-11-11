package com.example.gicws2.demo.Services;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String performTask() {
        try {
            Thread.sleep(500); // simulate a delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Task completed!";
    }
}