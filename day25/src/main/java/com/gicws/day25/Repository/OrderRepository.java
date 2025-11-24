package com.gicws.day25.Repository;

import com.gicws.day25.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query("SELECT o FROM Order o LEFT JOIN FETCH o.customer")
    List<Order> findAllWithCustomer();
}
