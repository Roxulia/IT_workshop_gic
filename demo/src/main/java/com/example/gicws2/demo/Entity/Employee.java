package com.example.gicws2.demo.Entity;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double salary;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}
