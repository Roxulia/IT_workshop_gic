package com.example.gicws2.demo.Classes;

//import org.apache.catalina.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Cars {
    @Autowired
    private Engines engine;

    // 🔹 Setter Injection
    @Autowired
    public void setEngine(Engines engine) {
        this.engine = engine;
    }

    public void drive() {
        engine.start();
        System.out.println("🏁 Car is driving...");
    }
}
