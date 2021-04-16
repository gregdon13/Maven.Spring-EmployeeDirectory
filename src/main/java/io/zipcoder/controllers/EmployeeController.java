package io.zipcoder.controllers;

import io.zipcoder.entities.Employee;
import io.zipcoder.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PutMapping("/company/employee/{id}")
    public Employee updateEmployeeManager(@PathVariable Long id, Employee manager) {
        Employee holder = employeeRepository.findOne(id);
        holder.setManager(manager);
        return employeeRepository.save(holder);
    }

    @PutMapping("/company/employee/{id}")
    public Employee updateEmployeeTitle(@PathVariable Long id, String title) {
        Employee holder = employeeRepository.findOne(id);
        holder.setTitle(title);
        return employeeRepository.save(holder);
    }

//    @PutMapping("/company/employee/{id}")
//    public Employee updateEmployeeDepartmentNumber(@PathVariable Long id, Long departmentNumber) {
//        Employee holder = employeeRepository.findOne(id);
//        holder.setDepartmentNumber();
//    }
}
