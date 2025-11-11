package com.example.gicws2.demo.Repository;

import com.example.gicws2.demo.Classes.Cars;
import com.example.gicws2.demo.Entity.MyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepository extends JpaRepository<MyEntity,Long> {
    @Override
    Page<MyEntity> findAll(Pageable pageable);
}
