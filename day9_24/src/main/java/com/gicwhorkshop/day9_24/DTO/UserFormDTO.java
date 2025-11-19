package com.gicwhorkshop.day9_24.DTO;

import com.gicwhorkshop.day9_24.Validation.ValidAge;
import jakarta.validation.constraints.*;

public class UserFormDTO {

    @NotBlank(message = "Name must not be empty")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email must not be empty")
    private String email;

    @ValidAge
    private Integer age;

    // Getters & Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
