package com.gicws.day26;

import com.gicws.day26.Entity.Category;
import com.gicws.day26.Entity.Product;
import com.gicws.day26.Repository.CategoryRepository;
import com.gicws.day26.Repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;

@DataJpaTest
public class CategoryProductEagerFetchTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testEagerFetchingLogging() {

        System.out.println("\n======= STEP 1: Saving data =======");

        Category c1 = new Category();
        c1.setName("Electronics");

        Product p1 = new Product();
        p1.setName("Laptop");
        p1.setPrice(1200.0);
        p1.setCategory(c1);

        Product p2 = new Product();
        p2.setName("Mouse");
        p2.setPrice(25.0);
        p2.setCategory(c1);

        c1.setProducts(Arrays.asList(p1, p2));

        categoryRepository.save(c1);

        System.out.println("Saved Category: " + c1.getName());
        System.out.println("Saved Products: Laptop, Mouse");

        System.out.println("\n======= STEP 2: Fetching Category (EAGER loads products) =======");

        Category fetched = categoryRepository.findById(c1.getId()).orElseThrow();

        System.out.println("Fetched Category: " + fetched.getName());
        System.out.println("EAGER fetch → products loaded automatically");

        fetched.getProducts().forEach(prod ->
                System.out.println("Product Loaded: " + prod.getName())
        );

        System.out.println("\n======= STEP 3: Fetching Product (EAGER loads category) =======");

        Product fetchedProduct = productRepository.findById(p1.getId()).orElseThrow();

        System.out.println("Fetched Product: " + fetchedProduct.getName());
        System.out.println("EAGER fetch → category loaded automatically");
        System.out.println("Category Loaded: " + fetchedProduct.getCategory().getName());

        System.out.println("\n======= END OF TEST =======\n");
    }
}
