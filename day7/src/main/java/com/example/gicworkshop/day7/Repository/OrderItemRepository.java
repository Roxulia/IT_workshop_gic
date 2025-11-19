package com.example.gicworkshop.day7.Repository;

import com.example.gicworkshop.day7.Entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
