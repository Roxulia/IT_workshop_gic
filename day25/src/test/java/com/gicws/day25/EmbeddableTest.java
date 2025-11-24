package com.gicws.day25;

import com.gicws.day25.Entity.Order;
import com.gicws.day25.Entity.Address;
import com.gicws.day25.Repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EmbeddableTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testEmbeddedAddress() {
        // Create order with embedded address
        Order order = new Order();

        Address address = new Address();
        address.setStreet("123 Main St");
        address.setCity("Springfield");
        address.setZipCode("12345");

        order.setShippingAddress(address);

        orderRepository.save(order);

        // Fetch order and check embedded address
        Order savedOrder = orderRepository.findById(1L).orElseThrow();

        assertThat(savedOrder.getShippingAddress()).isNotNull();
        assertThat(savedOrder.getShippingAddress().getCity()).isEqualTo("Springfield");
    }
}
