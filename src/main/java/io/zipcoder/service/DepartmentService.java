package io.zipcoder.service;

import io.zipcoder.entities.Department;
import io.zipcoder.entities.Employee;
import io.zipcoder.repositories.DepartmentRepository;
import io.zipcoder.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentService {
    private final DepartmentRepository repository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public Iterable<Department> index() {
        return repository.findAll();
    }

    public Department show(@PathVariable Long id) {
        return repository.findOne(id);
    }

    public Department create(Department department) {
        return repository.save(department);
    }

    public Department update(@PathVariable Long id, Department newDeptData) {
        Department originalDept = repository.findOne(id);
        originalDept.setManager(newDeptData.getManager());
        originalDept.setDepartmentName(newDeptData.getDepartmentName());
        originalDept.setDepartmentNumber(newDeptData.getDepartmentNumber());
        return repository.save(originalDept);
    }

    public Department updateManager(@PathVariable Long id, Employee manager) {
        Department originalDept = repository.findOne(id);
        originalDept.setManager(manager);
        return repository.save(originalDept);
    }

    public Department updateName(@PathVariable Long id, String name) {
        Department originalDept = repository.findOne(id);
        originalDept.setDepartmentName(name);
        return repository.save(originalDept);
    }

    public Department mergeDepartment(@PathVariable Long deptOne, @PathVariable Long deptTwo) {
        Department tempA = repository.findOne(deptOne);
        Department tempB = repository.findOne(deptTwo);
        tempB.getManager().setManager(tempA.getManager());
        for (Employee e : employeeRepository.findAll()) {
            if (e.getDepartmentNumber().equals(deptTwo)) {
                e.setDepartmentNumber(deptOne);
            }
        }
        return repository.save(tempB);
    }

    public Boolean delete(@PathVariable Long id) {
        repository.delete(id);
        return true;
    }
}
