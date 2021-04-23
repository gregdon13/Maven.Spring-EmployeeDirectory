package io.zipcoder.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Department {
    private @Id Long departmentNumber;
    private String departmentName;
    private Long managerId;

    public Department() {}

    public Department(Long departmentNumber, String departmentName, Long manager) {
        this.departmentNumber = departmentNumber;
        this.departmentName = departmentName;
        this.managerId = manager;
    }

    public Long getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(Long departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getManager() {
        return managerId;
    }

    public void setManager(Long manager) {
        this.managerId = manager;
    }
}
