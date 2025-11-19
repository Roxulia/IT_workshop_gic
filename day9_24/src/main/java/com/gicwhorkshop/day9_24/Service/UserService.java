package com.gicwhorkshop.day9_24.Service;

import com.gicwhorkshop.day9_24.DTO.UserDTO;
import com.gicwhorkshop.day9_24.Entity.Users;
import com.gicwhorkshop.day9_24.Repository.UsersRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UsersRepository userRepository;

    @Autowired
    public UserService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO getUserById(Long id) {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getAge()
        );
    }

    public Users updateUser(@Valid UserDTO user) {
        // Fetch existing user by ID (assumes your DTO has an id field)
        Users existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Update fields
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setAge(user.getAge());

        // Save updated entity
        return userRepository.save(existingUser);
    }
}
