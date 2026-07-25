package com.cognizant.ems.projection;

/**
 * Exercise 8: class-based (DTO) projection, populated via a JPQL constructor
 * expression - see EmployeeRepository.findDepartmentView(). Unlike the
 * interface-based projection, this is a concrete class Spring Data JPA
 * instantiates directly with `new` inside the query.
 */
public class EmployeeDepartmentView {

    private final Long employeeId;
    private final String employeeName;
    private final String departmentName;

    public EmployeeDepartmentView(Long employeeId, String employeeName, String departmentName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.departmentName = departmentName;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public String toString() {
        return "EmployeeDepartmentView{employeeId=" + employeeId
                + ", employeeName='" + employeeName + "'"
                + ", departmentName='" + departmentName + "'}";
    }
}
