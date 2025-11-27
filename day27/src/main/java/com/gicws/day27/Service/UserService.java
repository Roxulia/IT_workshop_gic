package com.gicws.day27.Service;


import com.gicws.day27.Repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {  // Constructor injection
        this.userRepository = userRepository;
    }
}