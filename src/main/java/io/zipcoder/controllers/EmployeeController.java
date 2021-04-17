package io.zipcoder.controllers;

import io.zipcoder.entities.Employee;
import io.zipcoder.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @PutMapping("/company/employee/{employeeId}")
    public Employee updateEmployeeManager(@PathVariable Long employeeId, Employee manager) {
        Employee holder = employeeRepository.findOne(employeeId);
        holder.setManager(manager);
        return employeeRepository.save(holder);
    }

    @PutMapping("/company/employee/{employeeId}")
    public Employee updateEmployeeTitle(@PathVariable Long employeeId, String title) {
        Employee holder = employeeRepository.findOne(employeeId);
        holder.setTitle(title);
        return employeeRepository.save(holder);
    }

    //uncertain
    @PutMapping("/company/employee/{employeeId}")
    public Employee updateEmployeeDepartmentNumber(@PathVariable Long employeeId, Long departmentNumber) {
        Employee holder = employeeRepository.findOne(employeeId);
        holder.setDepartmentNumber(departmentNumber);
        return employeeRepository.save(holder);
    }

    @GetMapping("/company/employee/manager/{employeeId}")
    public List<Employee> getEmployeeListUnderManager(@PathVariable Long employeeId) {
        List<Employee> empList = new ArrayList<>();
        for (Employee e : employeeRepository.findAll()) {
            if (e.getManager().getEmployeeId().equals(employeeId)) {
                empList.add(e);
            }
        }
        return empList;
    }

    @GetMapping("/company/employee/manager")
    public List<Employee> getEmployeeListNoManager() {
        List<Employee> empList = new ArrayList<>();
        for (Employee e : employeeRepository.findAll()) {
            if (e.getManager() == null) {
                empList.add(e);
            }
        }
        return empList;
    }

    //WIP
    @GetMapping("company/employee/managerUp/{employeeId}")
    public List<Employee> getManagerHierarchy(@PathVariable Long employeeId) {
        List<Employee> managerList = new ArrayList<>();
        Employee temp = employeeRepository.findOne(employeeId);
        while(temp.getManager() != null) {
            managerList.add(temp.getManager());
            temp = temp.getManager();
        }
        return managerList;
    }

    @GetMapping("/company/employee/{departmentNumber}")
    public List<Employee> getDepartmentEmployees(@PathVariable Long departmentNumber) {
        List<Employee> empList = new ArrayList<>();
        for (Employee e : employeeRepository.findAll()) {
            if (e.getDepartmentNumber().equals(departmentNumber)) {
                empList.add(e);
            }
        }
        return empList;
    }

    //WIP
    @GetMapping("company/employee/managerDown/{managerId}")
    public List<Employee> getAllReportingEmployees(@PathVariable Long managerId) {
        return null;
    }

    @DeleteMapping("/company/employee/{employeeId}")
    public void deleteMultipleEmployeesById(@PathVariable Long... employeeId) {
        for (Long l : employeeId) {
            employeeRepository.delete(l);
        }
    }

    @DeleteMapping("/company/employee/{departmentNumber}")
    public void deleteEmployeesOfDepartment(@PathVariable Long departmentNumber) {
        for (Employee e : employeeRepository.findAll()) {
            if (e.getDepartmentNumber().equals(departmentNumber)) {
                employeeRepository.delete(e);
            }
        }
    }

    //I think this is what they mean
    @DeleteMapping("/company/employee/managerDown/{managerId}")
    public void deleteAllEmployeesUnderManager(@PathVariable Long managerId) {
        for (Employee e : employeeRepository.findAll()) {
            if (e.getManager().getEmployeeId().equals(managerId)) {
                employeeRepository.delete(e);
            }
            if (e.getManager().getManager().getEmployeeId().equals(managerId)) {
                employeeRepository.delete(e);
            }
        }
    }

    //possibly a little weird
    @DeleteMapping("/company/employee/manager/{managerId}")
    public void deleteDirectEmployeesUnderManager(@PathVariable Long managerId) {
        for (Employee e : employeeRepository.findAll()) {
            if (e.getManager().getEmployeeId().equals(managerId)) {
                employeeRepository.delete(e);
            }
            if (e.getManager().getManager().getEmployeeId().equals(managerId)) {
                e.setManager(employeeRepository.findOne(managerId));
            }
        }
    }
}
