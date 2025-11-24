package com.gicws.day25.Entity;

import com.gicws.day25.Entity.Keys.OrderItemId;
import jakarta.persistence.*;

@Entity
public class OrderItem {

    @EmbeddedId
    private OrderItemId id;

    private int quantity;

    public OrderItem() {}

    public OrderItem(OrderItemId id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    // getters and setters
    public OrderItemId getId() { return id; }
    public void setId(OrderItemId id) { this.id = id; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
