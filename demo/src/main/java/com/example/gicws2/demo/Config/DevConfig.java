package com.example.gicws2.demo.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("Dev")
public class DevConfig {
    @Bean
    public CommandLineRunner initDevData() {
        return args -> {
            System.out.println("🚀 Running initialization code for DEV profile...");
            // Put your startup logic here (e.g., insert mock data, log setup, etc.)
        };
    }
}
