package com.example.gicworkshop.day7.Service;

import com.example.gicworkshop.day7.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository)
    {
        this.authorRepository = authorRepository;
    }
}
