package com.example.gicworkshop.day7.Entity;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // getters & setters


    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
