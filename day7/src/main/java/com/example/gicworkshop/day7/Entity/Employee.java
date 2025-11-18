package com.example.gicworkshop.day7.Entity;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @Transient
    private String temporaryToken;

    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

    // Constructors
    public Employee() {}
    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    // Getters & Setters
    public Long getId() { return Id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public void setTemporaryToken(String secretToken123) {
        this.temporaryToken = secretToken123;
    }

    public String getTemporaryToken() {
        return temporaryToken;
    }
}
