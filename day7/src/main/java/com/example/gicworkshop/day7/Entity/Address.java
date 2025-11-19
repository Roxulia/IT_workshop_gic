package com.example.gicworkshop.day7.Entity;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private String city;

    // Many Addresses --> belong to One User
    @ManyToOne
    @JoinColumn(name = "user_id")  // FK
    private Users user;

    // Getters & Setters
    public Long getId() { return id; }
    public String getStreet() { return street; }
    public String getCity() { return city; }
    public Users getUser() { return user; }

    public void setStreet(String street) { this.street = street; }
    public void setCity(String city) { this.city = city; }
    public void setUser(Users user) { this.user = user; }
}
