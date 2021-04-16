package io.zipcoder.controllers;

import io.zipcoder.entities.Department;
import io.zipcoder.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    private final DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @PostMapping("/company/department")
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }
}
