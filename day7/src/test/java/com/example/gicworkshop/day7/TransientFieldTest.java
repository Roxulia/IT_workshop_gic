package com.example.gicworkshop.day7;

import com.example.gicworkshop.day7.Entity.Employee;
import com.example.gicworkshop.day7.Repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TransientFieldTest {

    @Autowired
    private EmployeeRepository userRepository;

    @Test
    void testTransientFieldNotPersisted() {
        // Create a new user
        Employee user = new Employee();
        user.setName("john_doe");
        user.setTemporaryToken("secretToken123"); // transient field

        // Save user to DB
        Employee e = userRepository.save(user);

        // Fetch user from DB
        Employee savedUser = userRepository.findById(e.getId()).orElseThrow();

        // Verify regular fields are persisted
        assertThat(savedUser.getName()).isEqualTo("john_doe");

        // Verify transient field is NOT persisted (will be null after fetch)
        assertThat(savedUser.getTemporaryToken()).isNull();
    }
}
