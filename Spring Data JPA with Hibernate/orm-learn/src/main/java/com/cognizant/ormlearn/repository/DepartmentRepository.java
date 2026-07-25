package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Hands on 3 (doc 2): repository for the Department entity.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
