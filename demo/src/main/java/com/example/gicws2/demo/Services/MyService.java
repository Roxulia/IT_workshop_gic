package com.example.gicws2.demo.Services;

import com.example.gicws2.demo.Entity.MyEntity;
import com.example.gicws2.demo.Repository.MyRepository;
//import jakarta.persistence.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MyService {


    private final MyRepository repository;

    @Autowired
    public MyService(MyRepository repository){
        this.repository = repository;
    }

    @Cacheable("products")
    public String getProductById(Long id) {
        System.out.println("Fetching product from database...");
        // Simulate expensive operation
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        return "Product-" + id;
    }

    public void updateMyEntity(MyEntity myEntity)
    {
        repository.save(myEntity);

    }

    public List<MyEntity> getAllProducts()
    {
        return Arrays.asList(
                new MyEntity(1L,"HeHe"),
                new MyEntity(2L,"HaHa")
        );
    }

    public String run()
    {
        return("Running My Service");
    }

    public MyEntity getUserById(Long id) {
        return new MyEntity(1L,"HeHe");
    }
}
