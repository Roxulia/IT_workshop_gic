package com.gicws.day27.Repository;

import com.gicws.day27.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
