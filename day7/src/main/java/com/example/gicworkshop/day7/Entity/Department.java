package com.example.gicworkshop.day7.Entity;

import jakarta.persistence.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;

    @OneToMany(mappedBy = "department",cascade = CascadeType.REMOVE)
    private List<Employee> employeeList;

    // Constructors
    public Department() {}
    public Department(String name) { this.name = name; }

    // Getters & Setters
    public Long getId() { return Id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Employee> getEmployees() { return employeeList; }
    public void setEmployees(List<Employee> employees) { this.employeeList = employees; }
}
