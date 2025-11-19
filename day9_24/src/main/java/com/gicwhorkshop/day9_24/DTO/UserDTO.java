package com.gicwhorkshop.day9_24.DTO;

//package com.example.demo.dto;

public class UserDTO {

    private Long id;
    private String name;
    private String email;

    private Integer age;

    // Constructors
    public UserDTO() {}

    public UserDTO(Long id, String name, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }
}
