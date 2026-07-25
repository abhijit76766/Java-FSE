package com.cognizant.ems.service;

import com.cognizant.ems.model.Employee;
import com.cognizant.ems.projection.EmployeeDepartmentView;
import com.cognizant.ems.projection.EmployeeSummary;
import com.cognizant.ems.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Exercise 4: CRUD operations for Employee.
 * Exercise 5: custom/named query methods.
 * Exercise 6: pagination and sorting.
 * Exercise 8: projections.
 * Exercise 10: saveAll() benefits from the batch insert/update tuning
 * configured in application.properties (hibernate.jdbc.batch_size etc).
 */
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Transactional
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Exercise 10: a single transaction wrapping many saves lets Hibernate
    // batch the resulting INSERT statements per hibernate.jdbc.batch_size.
    @Transactional
    public List<Employee> createBatch(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    @Transactional(readOnly = true)
    public Employee get(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Employee not found: " + id));
    }

    @Transactional(readOnly = true)
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Transactional
    public Employee update(Long id, Employee changes) {
        Employee employee = get(id);
        employee.setName(changes.getName());
        employee.setEmail(changes.getEmail());
        employee.setDepartment(changes.getDepartment());
        return employeeRepository.save(employee);
    }

    @Transactional
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    // Exercise 5
    @Transactional(readOnly = true)
    public List<Employee> search(String nameContains) {
        return employeeRepository.findByNameContainingIgnoreCase(nameContains);
    }

    @Transactional(readOnly = true)
    public List<Employee> getByDepartmentName(String departmentName) {
        return employeeRepository.findByDepartmentName(departmentName);
    }

    // Exercise 6
    @Transactional(readOnly = true)
    public Page<Employee> getPage(int page, int size, String sortBy) {
        Pageable pageable = org.springframework.data.domain.PageRequest.of(
                page, size, Sort.by(sortBy).ascending());
        return employeeRepository.findAll(pageable);
    }

    // Exercise 8
    @Transactional(readOnly = true)
    public List<EmployeeSummary> getSummariesByDepartment(Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId, Sort.by("name").ascending());
    }

    @Transactional(readOnly = true)
    public List<EmployeeDepartmentView> getDepartmentView(Long departmentId) {
        return employeeRepository.findDepartmentView(departmentId);
    }
}
