package com.example.gicworkshop.day7;

import com.example.gicworkshop.day7.Entity.Order;
import com.example.gicworkshop.day7.Entity.OrderItem;
import com.example.gicworkshop.day7.Repository.OrderItemRepository;
import com.example.gicworkshop.day7.Repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@Transactional
public class OrphanRemovalTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Test
    public void testOrphanRemovalDeletesOrderItem() {
        // 1. Create Order
        Order order = new Order();

        OrderItem i1 = new OrderItem();
        i1.setProductName("Phone");

        OrderItem i2 = new OrderItem();
        i2.setProductName("Laptop");

        order.addItem(i1);
        order.addItem(i2);

        order = orderRepository.save(order); // persists everything
        Long itemIdToRemove = i1.getId();

        // Ensure items saved
        assertEquals(2, orderItemRepository.count());

        // 2. Remove one item
        order.removeItem(i1);
        orderRepository.save(order);

        // 3. Flush to trigger orphan removal
        orderRepository.flush();

        // Verify only one item remains
        assertEquals(1, orderItemRepository.count());

        // Verify orphan item is deleted from DB
        assertFalse(orderItemRepository.findById(itemIdToRemove).isPresent());
    }
}
