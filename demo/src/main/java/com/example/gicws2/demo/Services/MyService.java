package com.example.gicws2.demo.Services;

import com.example.gicws2.demo.Repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class MyService {


    private final MyRepository repository;

    @Autowired
    public MyService(MyRepository repository){
        this.repository = repository;
    }

    public String run()
    {
        return("Running My Service");
    }

}
