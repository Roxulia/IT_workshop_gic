package com.example.gicworkshop.day7.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class Order1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem1> items = new ArrayList<>();

    // helper methods for convenience
    public void addProduct(Product product, int qty) {
        OrderItem1 item = new OrderItem1(this, product, qty);
        items.add(item);
    }

    // getters, setters

}
