package com.example.gicworkshop.day7.Entity;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // ❌ No cascade here — PROBLEM
    @OneToMany(mappedBy = "blog")
    private List<Post> posts = new ArrayList<>();

    // getters & setters
}

