package com.example.gicworkshop.day7.CommandLineRunners;

import com.example.gicworkshop.day7.Entity.Department;
import com.example.gicworkshop.day7.Entity.Employee;
import com.example.gicworkshop.day7.Repository.DepartmentRepository;
import com.example.gicworkshop.day7.Repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final DepartmentRepository departmentRepo;
    private final EmployeeRepository employeeRepo;

    public DataLoader(DepartmentRepository departmentRepo, EmployeeRepository employeeRepo) {
        this.departmentRepo = departmentRepo;
        this.employeeRepo = employeeRepo;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Department dept = new Department("IT");
        departmentRepo.save(dept);

        Employee emp1 = new Employee("Alice", dept);
        Employee emp2 = new Employee("Bob", dept);
        employeeRepo.saveAll(List.of(emp1, emp2));
    }
}