package com.gicws.day25;

import com.gicws.day25.Entity.Employees;
import com.gicws.day25.Entity.Projects;
import com.gicws.day25.Repository.EmployeesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class LazyFetchTest {

    @Autowired
    private EmployeesRepository employeeRepository;

    @Test
    @Transactional
    public void testLazyFetchingProjects() {
        // Fetch employee
        System.out.println("Fetching only Employee");
        Employees alice = employeeRepository.findById(1L).orElseThrow();

        // At this point, projectsList should not be loaded yet
        // Accessing it triggers the lazy load
        System.out.println("Accessing Projects using Fetched Employee");
        List<Projects> projects = alice.getProjectsList();

        assertThat(projects).isNotNull();
        assertThat(projects.size()).isGreaterThan(0);

        // Print project names for confirmation
        projects.forEach(p -> System.out.println(p.getName()));
    }
}
