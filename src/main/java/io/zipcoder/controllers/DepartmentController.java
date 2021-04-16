package io.zipcoder.controllers;

import io.zipcoder.entities.Department;
import io.zipcoder.entities.Employee;
import io.zipcoder.repositories.DepartmentRepository;
import io.zipcoder.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    private final DepartmentRepository departmentRepository;
    @Autowired
    private final EmployeeRepository employeeRepository;

    public DepartmentController(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/company/department")
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @PutMapping("/company/department/manager/{departmentNumber}")
    public Department updateDepartmentManager(@PathVariable Long departmentNumber, Employee manager) {
        Department temp = departmentRepository.findOne(departmentNumber);
        temp.setManager(manager);
        return departmentRepository.save(temp);
    }

    @PutMapping("/company/department/name/{departmentNumber}")
    public Department updateDepartmentName(@PathVariable Long departmentNumber, String name) {
        Department temp = departmentRepository.findOne(departmentNumber);
        temp.setDepartmentName(name);
        return departmentRepository.save(temp);
    }

    //WIP
    @PutMapping("/company/department/merge/{departmentNumberOne}")
    public Department mergeDepartments(@PathVariable Long departmentNumberOne, Long departmentNumberTwo) {
        return null;
    }
}
