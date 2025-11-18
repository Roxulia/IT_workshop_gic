package com.example.gicworkshop.day7.Repository;

import com.example.gicworkshop.day7.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
