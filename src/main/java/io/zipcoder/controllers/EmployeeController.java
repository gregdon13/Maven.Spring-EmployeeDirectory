package io.zipcoder.controllers;

import io.zipcoder.entities.Employee;
import io.zipcoder.repositories.EmployeeRepository;
import io.zipcoder.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId) {
        return new ResponseEntity<>(employeeService.show(employeeId), HttpStatus.OK);
    }

    @GetMapping("/employee")
    public ResponseEntity<Iterable<Employee>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.index(), HttpStatus.OK);
    }

//    @PostMapping("/employee")
//    public ResponseEntity<Employee> createEmployee(Employee newHire) {
//
//        return new ResponseEntity<>(employeeService.create(newHire), HttpStatus.CREATED);
//    }
//
//    @PutMapping("/employee/{employeeId}")
//    public ResponseEntity<Employee> updateEmployeeManager(@PathVariable Long employeeId, Employee update) {
//        return new ResponseEntity<>(employeeService.update(employeeId, update), HttpStatus.OK);
//    }
//
//    @PutMapping("/employee/{employeeId}")
//    public ResponseEntity<Employee> updateEmployeeTitle(@PathVariable Long employeeId, Employee title) {
//        return new ResponseEntity<>(employeeService.update(employeeId, title), HttpStatus.OK);
//    }
//
//    //uncertain
//    @PutMapping("/employee/{employeeId}")
//    public ResponseEntity<Employee> updateEmployeeDepartmentNumber(@PathVariable Long employeeId, Employee departmentNumber) {
//        return new ResponseEntity<>(employeeService.update(employeeId, departmentNumber), HttpStatus.OK);
//    }
//
//    @GetMapping("/employee/manager/{employeeId}")
//    public List<Employee> getEmployeeListUnderManager(@PathVariable Long employeeId) {
//        List<Employee> empList = new ArrayList<>();
//        for (Employee e : employeeService.index()) {
//            if (e.getManager().getEmployeeId().equals(employeeId)) {
//                empList.add(e);
//            }
//        }
//        return empList;
//    }
//
//    @GetMapping("/employee/manager")
//    public List<Employee> getEmployeeListNoManager() {
//        List<Employee> empList = new ArrayList<>();
//        for (Employee e : employeeService.index()) {
//            if (e.getManager() == null) {
//                empList.add(e);
//            }
//        }
//        return empList;
//    }
//
//    //WIP
//    @GetMapping("/employee/managerUp/{employeeId}")
//    public List<Employee> getManagerHierarchy(@PathVariable Long employeeId) {
//        List<Employee> managerList = new ArrayList<>();
//        Employee temp = employeeService.show(employeeId);
//        while(temp.getManager() != null) {
//            managerList.add(temp.getManager());
//            temp = temp.getManager();
//        }
//        return managerList;
//    }
//
//    @GetMapping("/employee/{departmentNumber}")
//    public List<Employee> getDepartmentEmployees(@PathVariable Long departmentNumber) {
//        List<Employee> empList = new ArrayList<>();
//        for (Employee e : employeeService.index()) {
//            if (e.getDepartmentNumber().equals(departmentNumber)) {
//                empList.add(e);
//            }
//        }
//        return empList;
//    }
//
//    //WIP
//    @GetMapping("/employee/managerDown/{managerId}")
//    public List<Employee> getAllReportingEmployees(@PathVariable Long managerId) {
//        return null;
//    }
//
//    @DeleteMapping("/employee/{employeeId}")
//    public void deleteMultipleEmployeesById(@PathVariable Long... employeeId) {
//        for (Long l : employeeId) {
//            employeeService.deleteEmp(l);
//        }
//    }
//
//    @DeleteMapping("/employee/{departmentNumber}")
//    public void deleteEmployeesOfDepartment(@PathVariable Long departmentNumber) {
//        for (Employee e : employeeService.index()) {
//            if (e.getDepartmentNumber().equals(departmentNumber)) {
//                employeeService.deleteEmp(e);
//            }
//        }
//    }
//
//    //I think this is what they mean
//    @DeleteMapping("/employee/managerDown/{managerId}")
//    public void deleteAllEmployeesUnderManager(@PathVariable Long managerId) {
//        for (Employee e : employeeService.index()) {
//            if (e.getManager().getEmployeeId().equals(managerId)) {
//                employeeService.deleteEmp(e);
//            }
//            if (e.getManager().getManager().getEmployeeId().equals(managerId)) {
//                employeeService.deleteEmp(e);
//            }
//        }
//    }
//
//    //possibly a little weird
//    @DeleteMapping("/employee/manager/{managerId}")
//    public void deleteDirectEmployeesUnderManager(@PathVariable Long managerId) {
//        for (Employee e : employeeService.index()) {
//            if (e.getManager().getEmployeeId().equals(managerId)) {
//                employeeService.deleteEmp(e);
//            }
//            if (e.getManager().getManager().getEmployeeId().equals(managerId)) {
//                e.setManager(employeeService.show(managerId));
//            }
//        }
//    }
}
