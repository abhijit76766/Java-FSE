package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Hands on 4-6 (doc 2): Employee CRUD used by the relationship hands-on.
 * Hands on 2, 4, 5 (doc 3): HQL/JPQL, average salary, native query.
 * Hands on 6 (doc 3): Criteria Query dynamic search, modelled on the
 * "search a laptop with optional filters" scenario described in the doc.
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Employee get(int id) {
        return employeeRepository.findById(id).get();
    }

    @Transactional
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    // Hands on 2 (doc 3): all permanent employees, department and skills fetched.
    @Transactional
    public List<Employee> getAllPermanentEmployees() {
        return employeeRepository.getAllPermanentEmployees();
    }

    // Hands on 4 (doc 3): average salary overall / by department.
    @Transactional
    public Double getAverageSalary() {
        return employeeRepository.getAverageSalary();
    }

    @Transactional
    public Double getAverageSalary(int departmentId) {
        return employeeRepository.getAverageSalary(departmentId);
    }

    // Hands on 5 (doc 3): native SQL query.
    @Transactional
    public List<Employee> getAllEmployeesNative() {
        return employeeRepository.getAllEmployeesNative();
    }

    // Hands on 6 (doc 2): add an existing skill to an employee's skill list.
    @Transactional
    public void addSkillToEmployee(int employeeId, Skill skill) {
        Employee employee = get(employeeId);
        employee.getSkillList().add(skill);
        employeeRepository.save(employee);
    }

    /**
     * Hands on 6 (doc 3): Criteria Query dynamic search.
     * Any combination of the three filters may be supplied (null = ignore).
     * This is the programmatic equivalent of dynamically building a WHERE
     * clause based on which search filters a user has selected.
     */
    @Transactional
    public List<Employee> searchEmployees(String nameContains, Boolean permanent, BigDecimal minSalary) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> employee = query.from(Employee.class);

        List<Predicate> predicates = new ArrayList<>();
        if (nameContains != null && !nameContains.isEmpty()) {
            predicates.add(cb.like(cb.lower(employee.get("name")), "%" + nameContains.toLowerCase() + "%"));
        }
        if (permanent != null) {
            predicates.add(cb.equal(employee.get("permanent"), permanent));
        }
        if (minSalary != null) {
            predicates.add(cb.ge(employee.get("salary"), minSalary));
        }

        query.select(employee).where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(query).getResultList();
    }
}
