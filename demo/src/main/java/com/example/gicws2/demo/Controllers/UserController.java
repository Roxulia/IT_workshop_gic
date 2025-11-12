package com.example.gicws2.demo.Controllers;

import com.example.gicws2.demo.Entity.MyEntity;
import com.example.gicws2.demo.Services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController
{
    @Autowired
    private MyService userService;
    @GetMapping("/users/{id}")
    public ResponseEntity getUser(@PathVariable Long id)
    {
        MyEntity user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
}