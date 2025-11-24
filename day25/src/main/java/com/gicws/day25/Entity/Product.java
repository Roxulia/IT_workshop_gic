package com.gicws.day25.Entity;
import jakarta.persistence.*;
import org.hibernate.annotations.OptimisticLock;

import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int quantity;

    @OneToMany(mappedBy = "product")
    private List<Order> orders;

    @Version
    private Long version;  // Optimistic locking field

    // getters and setters


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public Long getVersion() {
        return version;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
