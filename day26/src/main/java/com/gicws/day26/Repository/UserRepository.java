package com.gicws.day26.Repository;

import com.gicws.day26.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmailEndingWith(String domain);
}
