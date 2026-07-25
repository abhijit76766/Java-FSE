package com.cognizant.ems.repository;

import com.cognizant.ems.model.Employee;
import com.cognizant.ems.projection.EmployeeDepartmentView;
import com.cognizant.ems.projection.EmployeeSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Exercise 3: repository for Employee, extending JpaRepository.
 * Exercise 5: derived query methods + custom @Query + named query.
 * Exercise 6: pagination and sorting via Page/Pageable.
 * Exercise 8: interface-based and class-based (DTO) projections.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // --- Exercise 5: derived query methods (keyword-based) ---
    List<Employee> findByNameContainingIgnoreCase(String name);

    List<Employee> findByDepartmentId(Long departmentId);

    // --- Exercise 5: custom query with @Query ---
    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee findByEmailAddress(@Param("email") String email);

    // --- Exercise 5: named query, resolved by name against
    // Employee's @NamedQuery definitions (see Employee.java) ---
    @Query(name = "Employee.findByDepartmentName")
    List<Employee> findByDepartmentName(@Param("departmentName") String departmentName);

    @Query(name = "Employee.findByEmailDomain")
    List<Employee> findByEmailDomain(@Param("domain") String domain);

    // --- Exercise 6: pagination + sorting ---
    // Sorting is supplied via Pageable.getSort(), e.g.
    // PageRequest.of(page, size, Sort.by("name").ascending())
    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findByDepartmentId(Long departmentId, Pageable pageable);

    // --- Exercise 8: interface-based projection ---
    List<EmployeeSummary> findByDepartmentId(Long departmentId, org.springframework.data.domain.Sort sort);

    // --- Exercise 8: class-based (DTO) projection via constructor expression ---
    @Query("SELECT new com.cognizant.ems.projection.EmployeeDepartmentView(e.id, e.name, e.department.name) "
            + "FROM Employee e WHERE e.department.id = :departmentId")
    List<EmployeeDepartmentView> findDepartmentView(@Param("departmentId") Long departmentId);
}
