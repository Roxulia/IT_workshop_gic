package com.gicws.day25;

import com.gicws.day25.Entity.Department;
import com.gicws.day25.Entity.Employees;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class DepartmentRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Test
    @Transactional
    public void testDeleteDepartmentDeletesEmployees() {
        System.out.println("=== Creating Department and Employees ===");

        Employees e1 = new Employees();
        e1.setName("Alice");
        Employees e2 = new Employees();
        e2.setName("Bob");

        Department dept = new Department();
        dept.setName("IT");
        dept.setEmployees(List.of(e1, e2));

        em.persist(dept);
        em.flush();
        System.out.println("Persisted Department: " + dept.getName() + " with Employees: " +
                dept.getEmployees().stream().map(Employees::getName).toList());

        System.out.println("=== Deleting Department ===");
        em.remove(dept);
        em.flush();
        System.out.println("Department deleted");

        // Check if employees are also deleted
        Employees foundE1 = em.find(Employees.class, e1.getId());
        Employees foundE2 = em.find(Employees.class, e2.getId());

        System.out.println("Employee Alice: " + (foundE1 != null ? "Exists" : "Deleted"));
        System.out.println("Employee Bob: " + (foundE2 != null ? "Exists" : "Deleted"));

        assertThat(foundE1).isNull();
        assertThat(foundE2).isNull();

        System.out.println("=== Test completed successfully ===");
    }
}

