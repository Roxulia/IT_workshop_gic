package com.example.gicws2.demo.Repository;

import com.example.gicws2.demo.DTO.UserDTO;
import com.example.gicws2.demo.Entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT new com.example.gicws2.demo.DTO.UserDTO(u.name, u.email) FROM User u WHERE u.active = true")
    List<UserDTO> findActiveUsers();

    @EntityGraph(attributePaths = {"orders"})
    List<User> findWithOrdersByActiveTrue();
}
