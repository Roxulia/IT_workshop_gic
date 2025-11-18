package com.example.gicworkshop.day7.Entity;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @ManyToOne()
    @JoinColumn(name = "author_id")
    private Author author;
}
