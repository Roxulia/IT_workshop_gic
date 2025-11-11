package com.example.gicws2.demo.Classes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application Started - running Startup Function");
    }
}
