package com.example.gicworkshop.day7.Repository;

import com.example.gicworkshop.day7.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
