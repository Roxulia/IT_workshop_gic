package com.gicws.day27.Controller;

import org.springframework.web.bind.annotation.*;

@RestController   // Correct for Q6
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from REST controller!";
    }
}