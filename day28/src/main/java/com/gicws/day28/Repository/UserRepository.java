package com.gicws.day28.Repository;

import com.gicws.day28.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
