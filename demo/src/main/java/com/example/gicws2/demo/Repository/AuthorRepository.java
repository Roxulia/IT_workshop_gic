package com.example.gicws2.demo.Repository;

import com.example.gicws2.demo.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Long> {

    @Query("SELECT a FROM Author a JOIN a.books b GROUP BY a HAVING COUNT(b) > 5")
    List<Author> findAuthorsWithMoreThanFiveBooks();

}
