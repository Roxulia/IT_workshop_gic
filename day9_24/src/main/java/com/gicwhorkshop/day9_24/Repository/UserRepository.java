package com.gicwhorkshop.day9_24.Repository;

import com.gicwhorkshop.day9_24.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
