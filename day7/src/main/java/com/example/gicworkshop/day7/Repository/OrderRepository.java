package com.example.gicworkshop.day7.Repository;

import com.example.gicworkshop.day7.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
