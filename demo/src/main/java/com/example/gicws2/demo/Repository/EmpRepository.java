package com.example.gicws2.demo.Repository;

import com.example.gicws2.demo.Entity.Department;
import com.example.gicws2.demo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmpRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByDepartment(Department department);


    @Query("SELECT e FROM Employee e JOIN FETCH e.department d WHERE e.salary > :minSalary AND d.name = :deptName")
    List<Employee> findBySalaryAndDepartment(@Param("minSalary") Double minSalary, @Param("deptName") String deptName);

    @Query("SELECT e FROM Employee e WHERE LOWER(e.department.name) = LOWER(:deptName)")
    List<Employee> findByDepartmentNameIgnoreCase(@Param("deptName") String deptName);

}
