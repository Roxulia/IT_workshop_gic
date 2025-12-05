package com.gicws.day28.DataObjects;

import com.gicws.day28.Validation.AgeValidation;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

public class UserData {

    private Long id;
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @AgeValidation(message = "Custom Message")
    private Integer age;

    public UserData()
    {

    }

    public Long getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
