package com.gicws.day25;

import com.gicws.day25.Entity.Product;
import jakarta.persistence.OptimisticLockException;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class LockingTest {

    @Autowired
    private TestEntityManager em;

    @Test
    @Transactional
    public void testOptimisticLocking() {
        Product p = new Product();
        p.setName("Laptop");
        p.setQuantity(10);
        em.persist(p);
        em.flush();

        System.out.println("Initial version: " + p.getVersion());

        // Simulate two transactions updating the same entity
        Product p1 = em.find(Product.class, p.getId());
        Product p2 = em.find(Product.class, p.getId());

        p1.setQuantity(15);
        em.flush();
        System.out.println("Updated quantity in p1: " + p1.getQuantity() + ", version: " + p1.getVersion());

        try {
            p2.setQuantity(20);
            em.flush(); // Should throw OptimisticLockException
        } catch (OptimisticLockException e) {
            System.out.println("OptimisticLockException occurred as expected: " + e.getMessage());
        }
    }
}
