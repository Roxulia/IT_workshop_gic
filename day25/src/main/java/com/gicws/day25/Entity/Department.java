package com.gicws.day25.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "department_id") // ensures the foreign key in Employee table
    private List<Employees> employees;

    // getters and setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Employees> getEmployees() { return employees; }
    public void setEmployees(List<Employees> employees) { this.employees = employees; }
}
