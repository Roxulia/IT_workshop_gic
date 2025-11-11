package com.example.gicws2.demo;

import com.example.gicws2.demo.Services.MyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyServiceTest {

    @Autowired
    private MyService myService;

    @Test
    void testMyService(){
        String str = myService.run();
        System.out.println(str);
    }
}
