package com.gicwhorkshop.day9_24.Service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Cacheable("products") // Cache the result of this method
    public List<String> getAllProducts() {
        simulateSlowService();
        return List.of("Laptop", "Phone", "Tablet");
    }

    private void simulateSlowService() {
        try {
            Thread.sleep(3000); // Simulate slow query
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
