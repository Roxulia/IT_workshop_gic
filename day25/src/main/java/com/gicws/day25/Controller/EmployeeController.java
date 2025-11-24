package com.gicws.day25.Controller;

import com.gicws.day25.Entity.Employees;
import com.gicws.day25.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity getAll() {
        try {
            List<Employees> employees = employeeService.getAll();
            return ResponseEntity.ok(employees);
        } catch (Exception e) {
            // Optional: log the exception
            e.printStackTrace();
            return ResponseEntity
                    .internalServerError()
                    .body("An error occurred while fetching employees.");
        }
    }


}
