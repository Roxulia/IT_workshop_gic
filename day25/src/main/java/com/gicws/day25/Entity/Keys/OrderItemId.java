package com.gicws.day25.Entity.Keys;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class OrderItemId implements Serializable {
    private Long orderId;
    private Long productId;

    public OrderItemId() {}

    public OrderItemId(Long orderId, Long productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    // getters and setters
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    // equals and hashCode are required for composite keys
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItemId)) return false;
        OrderItemId that = (OrderItemId) o;
        return orderId.equals(that.orderId) && productId.equals(that.productId);
    }

    @Override
    public int hashCode() {
        return 31 * orderId.hashCode() + productId.hashCode();
    }
}
