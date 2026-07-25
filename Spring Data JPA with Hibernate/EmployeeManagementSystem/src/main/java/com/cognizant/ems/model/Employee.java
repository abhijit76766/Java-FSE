package com.cognizant.ems.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Exercise 2: Employee entity with fields id, name, email, department.
 * Exercise 5: named queries, referenced from EmployeeRepository via
 * @Query(name = "...") - Spring Data JPA resolves the name against this
 * entity's @NamedQuery definitions before falling back to a derived query.
 * Exercise 10: @DynamicUpdate is a Hibernate-specific annotation - only
 * columns that actually changed are included in the generated UPDATE
 * statement, instead of every column.
 */
@Getter
@Setter
@ToString(exclude = "department")
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@Entity
@Table(name = "employee")
@NamedQueries({
        @NamedQuery(
                name = "Employee.findByDepartmentName",
                query = "SELECT e FROM Employee e WHERE e.department.name = :departmentName"),
        @NamedQuery(
                name = "Employee.findByEmailDomain",
                query = "SELECT e FROM Employee e WHERE e.email LIKE CONCAT('%@', :domain)")
})
public class Employee extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
