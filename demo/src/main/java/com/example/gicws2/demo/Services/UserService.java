package com.example.gicws2.demo.Services;

import com.example.gicws2.demo.Classes.Users;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    public List<Users> getAllUsers() {
        return Arrays.asList(
                new Users(1L, "Roxulia", "roxulia@example.com"),
                new Users(2L, "Alice", "alice@example.com"),
                new Users(3L, "Bob", "bob@example.com")
        );
    }

    public Users getUser(int id)
    {
        return  new Users(Long.valueOf(id),"hehe","hehe@gmail.com");
    }
}
