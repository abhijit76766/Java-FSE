package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * doc 3: "In EmployeeDao, incorporate the following: static variable
 * EMPLOYEE_LIST, constructor that reads employee list from xml config,
 * getAllEmployees()".
 * doc 4: updateEmployee()/deleteEmployee() operating on the same list.
 */
@Repository
public class EmployeeDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);

    @SuppressWarnings("unchecked")
    private static final List<Employee> EMPLOYEE_LIST;

    static {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = (List<Employee>) context.getBean("employeeList", ArrayList.class);
    }

    public List<Employee> getAllEmployees() {
        LOGGER.info("Start");
        LOGGER.debug("employees.size={}", EMPLOYEE_LIST.size());
        LOGGER.info("End");
        return EMPLOYEE_LIST;
    }

    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        LOGGER.info("Start");
        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
            if (EMPLOYEE_LIST.get(i).getId().equals(employee.getId())) {
                EMPLOYEE_LIST.set(i, employee);
                LOGGER.info("End");
                return;
            }
        }
        throw new EmployeeNotFoundException(employee.getId());
    }

    public void deleteEmployee(Long id) throws EmployeeNotFoundException {
        LOGGER.info("Start");
        Iterator<Employee> iterator = EMPLOYEE_LIST.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(id)) {
                iterator.remove();
                LOGGER.info("End");
                return;
            }
        }
        throw new EmployeeNotFoundException(id);
    }
}
