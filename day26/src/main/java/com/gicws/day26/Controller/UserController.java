package com.gicws.day26.Controller;

import com.gicws.day26.Entity.User;
import com.gicws.day26.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private  final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody User user) {
        try{
            userService.save(user);
            return ResponseEntity.ok("User created successfully");
        } catch (Exception e){
            return ResponseEntity.status(500).body("Error creating user: " + e.getMessage());
        }
    }
}
