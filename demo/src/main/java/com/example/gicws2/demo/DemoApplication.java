package com.example.gicws2.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}


/* @RestController
 class MyController {
    @Autowired
    private MyService myService;
    @GetMapping("/hello")
    public String hello() {
        return myService.getMessage();
    }
 }

 interface MyService {
    String getMessage();
 }

 @Service
 class MyServiceImpl implements MyService {
    public String getMessage() {
        return "Hello, World!";
    }
 }
 */
