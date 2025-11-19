package com.example.gicworkshop.day7.Entity;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")   // Avoid using reserved keyword "user"
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // One User --> Many Addresses
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    // Helper methods
    public void addAddress(Address address) {
        addresses.add(address);
        address.setUser(this);
    }

    public void removeAddress(Address address) {
        addresses.remove(address);
        address.setUser(null);
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public List<Address> getAddresses() { return addresses; }

    public void setName(String name) { this.name = name; }
}
