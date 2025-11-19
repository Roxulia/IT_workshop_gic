package com.example.gicworkshop.day7.Entity;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
