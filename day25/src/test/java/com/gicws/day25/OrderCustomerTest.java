package com.gicws.day25;

import com.gicws.day25.Entity.Customer;
import com.gicws.day25.Entity.Order;
import com.gicws.day25.Entity.Product;
import com.gicws.day25.Repository.CustomerRepository;
import com.gicws.day25.Repository.OrderRepository;
import com.gicws.day25.Repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class OrderCustomerTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testFetchOrdersWithCustomers() {
        Customer c1 = new Customer();
        c1.setName("Alice");
        customerRepository.save(c1);

        Product p1 = new Product();
        p1.setName("Laptop");
        p1.setQuantity(100);
        productRepository.save(p1);

        Product p2 = new Product();
        p2.setName("Mouse");
        p2.setQuantity(100);
        productRepository.save(p2);

        Order o1 = new Order();
        o1.setProduct(p1);
        o1.setCustomer(c1);
        Order o2 = new Order();
        o2.setProduct(p2);
        o2.setCustomer(c1);

        orderRepository.save(o1);
        orderRepository.save(o2);

        System.out.println("=== Fetching orders with customers ===");
        orderRepository.findAllWithCustomer().forEach(o -> {
            System.out.println("Order: " + o.getProduct().getName() + ", Customer: " + o.getCustomer().getName());
        });
    }
}

