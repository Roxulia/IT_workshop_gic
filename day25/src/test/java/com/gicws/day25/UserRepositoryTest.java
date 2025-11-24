package com.gicws.day25;

import com.gicws.day25.Entity.User;
import com.gicws.day25.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByEmailOrderByRegistrationDateDesc() {
        // Setup
        User u1 = new User();
        u1.setEmail("alice@example.com");
        u1.setName("Alice");
        u1.setRegistrationDate(LocalDateTime.now().minusDays(1));

        User u2 = new User();
        u2.setEmail("alice@example.com");
        u2.setName("Alice2");
        u2.setRegistrationDate(LocalDateTime.now());

        userRepository.save(u1);
        userRepository.save(u2);

        // Execute
        List<User> users = userRepository.findByEmailOrderByRegistrationDateDesc("alice@example.com");

        // Verify
        assertThat(users).hasSize(2);
        assertThat(users.get(0).getRegistrationDate()).isAfter(users.get(1).getRegistrationDate());
    }

    @Test
    public void testFindAllByOrderByCreatedAtDesc() {
        User u1 = new User();
        u1.setEmail("a@example.com");
        u1.setRegistrationDate(LocalDateTime.now().minusDays(1));

        User u2 = new User();
        u2.setEmail("b@example.com");
        u2.setRegistrationDate(LocalDateTime.now());

        userRepository.save(u1);
        userRepository.save(u2);

        //List<User> users = userRepository.selectAllByOrderByRegistrationDateDesc();
        //assertThat(users.get(0).getEmail()).isEqualTo("b@example.com");
    }
}
