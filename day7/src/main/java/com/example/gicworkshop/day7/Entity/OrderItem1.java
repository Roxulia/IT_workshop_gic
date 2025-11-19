package com.example.gicworkshop.day7.Entity;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class OrderItem1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order1 order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    public OrderItem1() {}

    public OrderItem1(Order1 order, Product product, int quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    // getters, setters
}
