package com.example.gicws2.demo.Entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private Boolean active;

    @Version
    private Long version; // used for optimistic locking

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Orders> orders;
    // getters and setters
}
