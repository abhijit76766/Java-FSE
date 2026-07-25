package com.cognizant.ems.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.BatchSize;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Exercise 2: Department entity with fields id, name.
 * Exercise 2: one-to-many relationship with Employee.
 * Exercise 10: @BatchSize is a Hibernate-specific annotation that batches the
 * SELECTs used to initialize this lazy collection for several departments at
 * once, instead of firing one query per department (N+1 problem).
 */
@Getter
@Setter
@ToString(exclude = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "department")
public class Department extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @JsonIgnore
    @BatchSize(size = 20)
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Employee> employees = new ArrayList<>();
}
