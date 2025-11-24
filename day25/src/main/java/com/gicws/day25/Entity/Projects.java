package com.gicws.day25.Entity;

import jakarta.persistence.*;

@Entity
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employees employees;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }
}
