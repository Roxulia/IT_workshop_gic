package com.gicws.day25.Entity;


import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;

import java.util.List;

@Entity
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "employees", fetch =  FetchType.LAZY)
    private List<Projects> projectsList;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Projects> getProjectsList() {
        return projectsList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProjectsList(List<Projects> projectsList) {
        this.projectsList = projectsList;
    }
}
