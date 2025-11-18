package com.example.gicworkshop.day7;

import com.example.gicworkshop.day7.Entity.Employee;
import com.example.gicworkshop.day7.Repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LazyLoadingTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    @Transactional
    void testLazyLoading() {
        Employee emp = employeeRepository.findById(1L).orElseThrow();

        System.out.println("Employee name: " + emp.getName());

        // At this point, Department is not loaded yet (proxy)
        System.out.println("Department class: " + emp.getDepartment().getClass());

        // Accessing department triggers the SQL query
        System.out.println("Department name: " + emp.getDepartment().getName());
    }
}
