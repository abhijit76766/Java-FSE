package com.cognizant.ems.repository;

import com.cognizant.ems.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Exercise 3: repository for Department, extending JpaRepository.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Derived query method - Exercise 3.
    Optional<Department> findByName(String name);
}
