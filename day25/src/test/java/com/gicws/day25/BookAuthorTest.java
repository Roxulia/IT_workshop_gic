package com.gicws.day25;

import com.gicws.day25.Entity.Book;
import com.gicws.day25.Entity.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookAuthorTest {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    public void testDeleteBookDoesNotDeleteAuthors() {
        System.out.println("=== Creating Authors ===");
        Author a1 = new Author();
        a1.setName("Author 1");
        Author a2 = new Author();
        a2.setName("Author 2");

        System.out.println("=== Creating Book and associating Authors ===");
        Book book = new Book();
        book.setTitle("Spring JPA Book");
        book.setAuthors(List.of(a1, a2));

        // Persist book (authors will be persisted automatically due to CascadeType.PERSIST)
        em.persist(book);
        em.flush();
        System.out.println("Persisted Book: " + book.getTitle() + " with Authors: " +
                book.getAuthors().stream().map(Author::getName).toList());

        System.out.println("=== Deleting Book ===");
        em.remove(book);
        em.flush();
        System.out.println("Book deleted");

        // Verify authors still exist
        Author foundA1 = em.find(Author.class, a1.getId());
        Author foundA2 = em.find(Author.class, a2.getId());

        System.out.println("Checking if authors still exist after book deletion...");
        System.out.println("Author 1: " + (foundA1 != null ? "Exists" : "Deleted"));
        System.out.println("Author 2: " + (foundA2 != null ? "Exists" : "Deleted"));

        assertThat(foundA1).isNotNull();
        assertThat(foundA2).isNotNull();

        System.out.println("=== Test completed successfully ===");
    }
}
