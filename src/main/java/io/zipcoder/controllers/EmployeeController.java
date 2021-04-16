package io.zipcoder.controllers;

import io.zipcoder.entities.Employee;
import io.zipcoder.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/company/employee")
    public Employee createEmployee(Employee newHire) {
        return employeeRepository.save(newHire);
    }
}
