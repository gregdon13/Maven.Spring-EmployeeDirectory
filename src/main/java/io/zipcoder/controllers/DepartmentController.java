package io.zipcoder.controllers;

import io.zipcoder.entities.Department;
import io.zipcoder.entities.Employee;
import io.zipcoder.repositories.DepartmentRepository;
import io.zipcoder.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/company/department")
    public List<Department> getDepartmentList() {
        List<Department> outlist = new ArrayList<>();
        for (Department d : departmentRepository.findAll()) {
            outlist.add(d);
        }
        return outlist;
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

    //uncertain
    @PutMapping("/company/department/merge/{departmentNumberOne}/{departmentNumberTwo}")
    public Department mergeDepartments(@PathVariable Long departmentNumberOne, @PathVariable Long departmentNumberTwo) {
        Department tempA = departmentRepository.findOne(departmentNumberOne);
        Department tempB = departmentRepository.findOne(departmentNumberTwo);
        tempB.getManager().setManager(tempA.getManager());
        for (Employee e : employeeRepository.findAll()){
            if (e.getDepartmentNumber().equals(departmentNumberTwo)) {
                e.setDepartmentNumber(departmentNumberOne);
            }
        }
        return departmentRepository.save(tempB);
    }
}
