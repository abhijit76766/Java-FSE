package com.cognizant.ems.controller;

import com.cognizant.ems.model.Employee;
import com.cognizant.ems.projection.EmployeeDepartmentView;
import com.cognizant.ems.projection.EmployeeSummary;
import com.cognizant.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Exercise 4: RESTful CRUD endpoints for Employee.
 * Exercise 5: search endpoint backed by derived/custom/named query methods.
 * Exercise 6: paged + sorted listing endpoint.
 * Exercise 8: projection endpoints.
 */
@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @PostMapping("/batch")
    public List<Employee> createBatch(@RequestBody List<Employee> employees) {
        return employeeService.createBatch(employees);
    }

    @GetMapping("/{id}")
    public Employee get(@PathVariable Long id) {
        return employeeService.get(id);
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeService.delete(id);
    }

    // Exercise 5: search by (partial, case-insensitive) name.
    @GetMapping("/search")
    public List<Employee> search(@RequestParam String name) {
        return employeeService.search(name);
    }

    // Exercise 5: named-query-backed lookup by department name.
    @GetMapping("/by-department-name")
    public List<Employee> byDepartmentName(@RequestParam String departmentName) {
        return employeeService.getByDepartmentName(departmentName);
    }

    // Exercise 6: paginated + sorted employee listing.
    // e.g. GET /api/employees/page?page=0&size=10&sortBy=name
    @GetMapping("/page")
    public Page<Employee> getPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return employeeService.getPage(page, size, sortBy);
    }

    // Exercise 8: interface-based projection (id, name, email only).
    @GetMapping("/department/{departmentId}/summary")
    public List<EmployeeSummary> getSummaries(@PathVariable Long departmentId) {
        return employeeService.getSummariesByDepartment(departmentId);
    }

    // Exercise 8: class-based (DTO) projection via constructor expression.
    @GetMapping("/department/{departmentId}/view")
    public List<EmployeeDepartmentView> getDepartmentView(@PathVariable Long departmentId) {
        return employeeService.getDepartmentView(departmentId);
    }
}
