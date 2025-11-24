package com.gicws.day25.Repository;

import com.gicws.day25.Entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employees,Long> {
}
