package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Hands on 2 (doc 3): HQL/JPQL with @Query.
 * Hands on 4 (doc 3): average salary, with and without a department filter.
 * Hands on 5 (doc 3): native SQL query.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Hands on 2: 'fetch' after each join avoids N+1 selects and the
    // LazyInitializationException that appears without it (see README).
    @Query(value = "SELECT e FROM Employee e "
            + "left join fetch e.department d "
            + "left join fetch e.skillList "
            + "WHERE e.permanent = true")
    List<Employee> getAllPermanentEmployees();

    // Hands on 4: average salary across all employees.
    @Query(value = "SELECT AVG(e.salary) FROM Employee e")
    Double getAverageSalary();

    // Hands on 4: average salary filtered by department id.
    @Query(value = "SELECT AVG(e.salary) FROM Employee e where e.department.id = :id")
    Double getAverageSalary(@Param("id") int id);

    // Hands on 5: native SQL instead of HQL/JPQL - avoid unless HQL cannot
    // express the query, since it ties the code to the database dialect.
    @Query(value = "SELECT * FROM employee", nativeQuery = true)
    List<Employee> getAllEmployeesNative();
}
