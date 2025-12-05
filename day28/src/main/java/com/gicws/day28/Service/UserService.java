package com.gicws.day28.Service;

import com.gicws.day28.DataObjects.UserData;
import com.gicws.day28.Entity.User;
import com.gicws.day28.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserData userData) throws Exception
    {
        try{
            User u = new User();
            u.setName(userData.getName());
            u.setEmail(userData.getEmail());
            u.setAge(userData.getAge());
            userRepository.save(u);
        }
        catch (Exception e)
        {
            throw new Exception("Error creating user: " + e.getMessage());
        }
    }

    public List<UserData> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> {
            UserData userData = new UserData();
            userData.setId(user.getId());
            userData.setName(user.getName());
            userData.setEmail(user.getEmail());
            userData.setAge(user.getAge());
            return userData;
        }).toList();
    }
}
