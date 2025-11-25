package com.gicws.day26.Service;

import com.gicws.day26.Entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void save(User user) {
        // Logic to create a user
        System.out.println("User " + user.getUsername() + " created.");
    }
}
