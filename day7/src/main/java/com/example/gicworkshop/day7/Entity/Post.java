package com.example.gicworkshop.day7.Entity;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;

    // ❌ No cascade here — PROBLEM
    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    // getters & setters
}

