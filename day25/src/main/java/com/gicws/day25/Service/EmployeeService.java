package com.gicws.day25.Service;

import com.gicws.day25.Entity.Employees;
import com.gicws.day25.Repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeesRepository employeesRepository;

    @Autowired
    public EmployeeService(EmployeesRepository employeesRepository)
    {
        this.employeesRepository = employeesRepository;
    }

    public List<Employees> getAll()
    {
        return  employeesRepository.findAll();
    }
}
