package com.gicws.day25;

import com.gicws.day25.Entity.User;
import com.gicws.day25.Repository.UserRepository;
import com.gicws.day25.Specification.UserSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserSpecificationTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        User u1 = new User();
        u1.setName("Alice");
        u1.setEmail("alice@example.com");
        u1.setAge(25);

        User u2 = new User();
        u2.setName("Bob");
        u2.setEmail("bob@example.com");
        u2.setAge(30);

        User u3 = new User();
        u3.setName("Charlie");
        u3.setEmail("charlie@test.com");
        u3.setAge(22);

        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);
    }

    @Test
    public void testDynamicQueryWithSpecifications() {
        // Define dynamic criteria
        Specification<User> spec = Specification
                .where(UserSpecification.hasName("Alice"))
                .and(UserSpecification.hasEmail("example.com"))
                .and(UserSpecification.ageBetween(20, 30));

        List<User> users = userRepository.findAll(spec);

        System.out.println("=== Users matching criteria ===");
        users.forEach(u -> System.out.println(
                "Name: " + u.getName() +
                        ", Email: " + u.getEmail() +
                        ", Age: " + u.getAge()
        ));

        // Assertions
        assertThat(users).hasSize(1);
        assertThat(users.get(0).getName()).isEqualTo("Alice");
    }
}

