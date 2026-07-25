package com.cognizant.ormlearn.runner;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.StockService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Runs every "test*()" scenario described across docs 1-3 in order, the same
 * way the original hands-on exercises the code from OrmLearnApplication's
 * main() method. Toggle scenarios on/off by commenting out calls in run().
 */
@Component
@Order(1)
public class DemoRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoRunner.class);

    @Autowired
    private CountryService countryService;
    @Autowired
    private StockService stockService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private EmployeeService employeeService;

    @Override
    public void run(String... args) throws Exception {
        // ----- doc 1: Country CRUD (Hands on 1, 6-9) -----
        testGetAllCountries();
        getAllCountriesTest();
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry();

        // ----- doc 2: Query Methods (Hands on 1, 2) -----
        testCountrySearch();
        testStockQueries();

        // ----- doc 2: Relationships (Hands on 4, 5, 6) -----
        testGetEmployee();
        testAddEmployee();
        testUpdateEmployee();
        testGetDepartment();
        testAddSkillToEmployee();

        // ----- doc 3: HQL/JPQL, native query, criteria query (Hands on 2, 4, 5, 6) -----
        testGetAllPermanentEmployees();
        testAverageSalary();
        testGetAllEmployeesNative();
        testCriteriaSearch();
    }

    // Hands on 1 (doc 1)
    private void testGetAllCountries() {
        LOGGER.info("Start");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries.size={}", countries.size());
        LOGGER.info("End");
    }

    // Hands on 6 (doc 1)
    private void getAllCountriesTest() throws CountryNotFoundException {
        LOGGER.info("Start");
        Country country = countryService.findCountryByCode("IN");
        LOGGER.debug("Country:{}", country);
        LOGGER.info("End");
    }

    // Hands on 7 (doc 1)
    private void testAddCountry() throws CountryNotFoundException {
        LOGGER.info("Start");
        Country zz = new Country("ZZ", "Zenith Land");
        countryService.addCountry(zz);
        Country added = countryService.findCountryByCode("ZZ");
        LOGGER.debug("Added country:{}", added);
        LOGGER.info("End");
    }

    // Hands on 8 (doc 1)
    private void testUpdateCountry() throws CountryNotFoundException {
        LOGGER.info("Start");
        countryService.updateCountry("ZZ", "Zenith Republic");
        Country updated = countryService.findCountryByCode("ZZ");
        LOGGER.debug("Updated country:{}", updated);
        LOGGER.info("End");
    }

    // Hands on 9 (doc 1)
    private void testDeleteCountry() {
        LOGGER.info("Start");
        countryService.deleteCountry("ZZ");
        LOGGER.info("End");
    }

    // Hands on 1 (doc 2): search-as-you-type + alphabet index.
    private void testCountrySearch() {
        LOGGER.info("Start");
        List<Country> matches = countryService.searchCountries("ou");
        LOGGER.debug("Countries containing 'ou' (sorted): {}", matches);

        List<Country> startingWithZ = countryService.findCountriesStartingWith("Z");
        LOGGER.debug("Countries starting with 'Z': {}", startingWithZ);
        LOGGER.info("End");
    }

    // Hands on 2 (doc 2): stock Query Methods.
    private void testStockQueries() {
        LOGGER.info("Start");
        List<Stock> septemberFb = stockService.getStockInRange(
                "FB", LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30));
        LOGGER.debug("FB stock in Sep 2019: {}", septemberFb);

        List<Stock> googleAbove1250 = stockService.getStockAbovePrice("GOOGL", new BigDecimal("1250"));
        LOGGER.debug("GOOGL close > 1250: {}", googleAbove1250);

        List<Stock> topVolumeFb = stockService.getTopVolumeDays("FB");
        LOGGER.debug("Top 3 FB volume days: {}", topVolumeFb);

        List<Stock> lowestNflx = stockService.getLowestCloseDays("NFLX");
        LOGGER.debug("Lowest 3 NFLX close days: {}", lowestNflx);
        LOGGER.info("End");
    }

    // Hands on 4 (doc 2): ManyToOne - get employee with department.
    private void testGetEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee:{}", employee);
        LOGGER.debug("Department:{}", employee.getDepartment());
        LOGGER.debug("Skills:{}", employee.getSkillList());
        LOGGER.info("End");
    }

    // Hands on 4 (doc 2): ManyToOne - add employee.
    private void testAddEmployee() {
        LOGGER.info("Start");
        Employee employee = new Employee();
        employee.setName("Nisha Verma");
        employee.setSalary(65000.0);
        employee.setPermanent(true);
        employee.setDateOfBirth(LocalDate.of(1994, 6, 12));
        employee.setDepartment(departmentService.get(1));
        employeeService.save(employee);
        LOGGER.debug("Added employee:{}", employee);
        LOGGER.info("End");
    }

    // Hands on 4 (doc 2): ManyToOne - update employee's department.
    private void testUpdateEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(1);
        employee.setDepartment(departmentService.get(2));
        employeeService.save(employee);
        LOGGER.debug("Updated employee:{}", employee);
        LOGGER.info("End");
    }

    // Hands on 5 (doc 2): OneToMany - get department with employee list.
    private void testGetDepartment() {
        LOGGER.info("Start");
        Department department = departmentService.get(1);
        LOGGER.debug("Department:{}", department);
        LOGGER.debug("Employees:{}", department.getEmployeeList());
        LOGGER.info("End");
    }

    // Hands on 6 (doc 2): ManyToMany - add a skill to an employee.
    private void testAddSkillToEmployee() {
        LOGGER.info("Start");
        Skill skill = skillService.get(1);
        employeeService.addSkillToEmployee(2, skill);
        LOGGER.debug("Employee 2 skills after update:{}", employeeService.get(2).getSkillList());
        LOGGER.info("End");
    }

    // Hands on 2 (doc 3): HQL with fetch joins.
    private void testGetAllPermanentEmployees() {
        LOGGER.info("Start");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        LOGGER.debug("Permanent Employees:{}", employees);
        employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
        LOGGER.info("End");
    }

    // Hands on 4 (doc 3): average salary, overall and by department.
    private void testAverageSalary() {
        LOGGER.info("Start");
        LOGGER.debug("Average salary (all): {}", employeeService.getAverageSalary());
        LOGGER.debug("Average salary (dept 1): {}", employeeService.getAverageSalary(1));
        LOGGER.info("End");
    }

    // Hands on 5 (doc 3): native SQL query.
    private void testGetAllEmployeesNative() {
        LOGGER.info("Start");
        List<Employee> employees = employeeService.getAllEmployeesNative();
        LOGGER.debug("All employees (native query):{}", employees);
        LOGGER.info("End");
    }

    // Hands on 6 (doc 3): Criteria Query dynamic search.
    private void testCriteriaSearch() {
        LOGGER.info("Start");
        List<Employee> permanentHighEarners = employeeService.searchEmployees(null, true, new BigDecimal("50000"));
        LOGGER.debug("Permanent employees earning >= 50000: {}", permanentHighEarners);

        List<Employee> nameMatch = employeeService.searchEmployees("a", null, null);
        LOGGER.debug("Employees with 'a' in the name: {}", nameMatch);
        LOGGER.info("End");
    }
}
