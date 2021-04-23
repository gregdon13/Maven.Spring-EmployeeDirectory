package io.zipcoder.controllers;

import io.zipcoder.entities.Department;
import io.zipcoder.entities.Employee;
import io.zipcoder.repositories.DepartmentRepository;
import io.zipcoder.repositories.EmployeeRepository;
import io.zipcoder.service.DepartmentService;
import io.zipcoder.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    //gets all departments
    @GetMapping("/department")
    public ResponseEntity<Iterable<Department>> getDepartmentList() {
        return new ResponseEntity<>(departmentService.index(), HttpStatus.OK);
    }

    @PostMapping("/department")
    public ResponseEntity<Department> createDepartment(Department department) {
        return new ResponseEntity<>(departmentService.create(department), HttpStatus.CREATED);
    }

    @PutMapping("/department/manager/{departmentNumber}")
    public ResponseEntity<Department> updateDepartmentManager(@PathVariable Long departmentNumber, Long managerId) {
        return new ResponseEntity<>(departmentService.updateManager(departmentNumber, managerId), HttpStatus.OK);
    }

    @PutMapping("/department/name/{departmentNumber}")
    public ResponseEntity<Department> updateDepartmentName(@PathVariable Long departmentNumber, String name) {
        return new ResponseEntity<>(departmentService.updateName(departmentNumber, name), HttpStatus.OK);
    }

    //uncertain
    //needs employee service
    @PutMapping("/department/merge/{departmentNumberOne}/{departmentNumberTwo}")
    public ResponseEntity<Department> mergeDepartments(@PathVariable Long departmentNumberOne, @PathVariable Long departmentNumberTwo) {
        return new ResponseEntity<>(departmentService.mergeDepartment(departmentNumberOne, departmentNumberTwo), HttpStatus.OK);
    }
}
