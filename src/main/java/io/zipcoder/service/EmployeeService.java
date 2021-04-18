package io.zipcoder.service;

import io.zipcoder.entities.Employee;
import io.zipcoder.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Iterable<Employee> index() {
        return employeeRepository.findAll();
    }

    public Employee show(@PathVariable Long id) {
        return employeeRepository.findOne(id);
    }

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Boolean deleteEmp(@PathVariable Long id) {
        employeeRepository.delete(id);
        return true;
    }

    public Boolean deleteEmp(Employee employee) {
        employeeRepository.delete(employee);
        return true;
    }

    public Employee update(@PathVariable Long id, Employee employee) {
        Employee holder = employeeRepository.findOne(id);
        if (!holder.getDepartmentNumber().equals(employee.getDepartmentNumber())) {
            holder.setDepartmentNumber(employee.getDepartmentNumber());
        } else if (!holder.getManager().equals(employee.getManager())) {
            holder.setManager(employee.getManager());
        } else if (!holder.getTitle().equals(employee.getTitle())) {
            holder.setTitle(employee.getTitle());
        } else if (!holder.getLastName().equals(employee.getLastName())) {
            holder.setLastName(employee.getLastName());
        }
        return employeeRepository.save(holder);
    }
}
