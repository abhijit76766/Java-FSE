package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * doc 3: "DepartmentDao.getAllDepartments() - Create a static variable
 * DEPARTMENT_LIST, this should be populated from spring xml configuration".
 */
@Repository
public class DepartmentDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentDao.class);

    @SuppressWarnings("unchecked")
    private static final List<Department> DEPARTMENT_LIST;

    static {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        DEPARTMENT_LIST = (List<Department>) context.getBean("departmentList", ArrayList.class);
    }

    public List<Department> getAllDepartments() {
        LOGGER.info("Start");
        LOGGER.debug("departments.size={}", DEPARTMENT_LIST.size());
        LOGGER.info("End");
        return DEPARTMENT_LIST;
    }
}
