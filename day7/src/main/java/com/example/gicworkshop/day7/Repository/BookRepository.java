package com.example.gicworkshop.day7.Repository;

import com.example.gicworkshop.day7.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
