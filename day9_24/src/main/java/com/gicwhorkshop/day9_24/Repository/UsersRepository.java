package com.gicwhorkshop.day9_24.Repository;

import com.gicwhorkshop.day9_24.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {
}
