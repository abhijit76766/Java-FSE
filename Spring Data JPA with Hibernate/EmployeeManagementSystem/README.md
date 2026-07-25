# EmployeeManagementSystem

Solutions for `Spring_Data_JPA_and_Hibernate.docx` (Exercises 1-10).

## Mapping exercises → code

| Exercise | Feature | Where |
|---|---|---|
| 1 | Spring Boot project + H2/Web/Lombok deps + application.properties | `pom.xml`, `application.properties` |
| 2 | Employee/Department entities + one-to-many | `model/Employee.java`, `model/Department.java` |
| 3 | Repositories extending JpaRepository + derived queries | `repository/*.java` |
| 4 | CRUD + REST endpoints | `service/*.java`, `controller/*.java` |
| 5 | Derived queries, `@Query`, `@NamedQuery`/`@NamedQueries` | `model/Employee.java` (named queries), `repository/EmployeeRepository.java` |
| 6 | Pagination + sorting | `repository/EmployeeRepository.java#findAll/findByDepartmentId(Pageable)`, `EmployeeController#getPage` |
| 7 | Entity auditing (`@CreatedBy`/`@LastModifiedBy`/`@CreatedDate`/`@LastModifiedDate`) | `model/Auditable.java`, `config/JpaAuditingConfig.java`, `config/AuditorAwareImpl.java` |
| 8 | Interface-based + class-based (DTO) projections | `projection/EmployeeSummary.java`, `projection/EmployeeDepartmentView.java` |
| 9 | Auto-configured primary data source + externalized second data source | `config/DataSourceConfig.java`, `service/ReportingService.java` |
| 10 | Hibernate-specific annotations + batch processing | `@DynamicUpdate` (Employee), `@BatchSize` (Department.employees), `application.properties` batch settings, `EmployeeService#createBatch` |

## Notable design choices / simplifications

- **Exercise 9 (multiple data sources):** implemented as a primary
  Spring-Boot-auto-configured `DataSource` (JPA, for Employee/Department) plus
  a second, fully independent `DataSource`/`JdbcTemplate` pair (for
  "reporting"), rather than two full JPA `EntityManagerFactory` +
  `PlatformTransactionManager` stacks. A true second *JPA* data source needs
  separate `@EnableJpaRepositories(basePackages=..., entityManagerFactoryRef=...)`
  configuration per data source — straightforward to add if you need JPA
  (rather than JdbcTemplate) against the second database too; the plumbing in
  `config/DataSourceConfig.java` is the piece to extend.
- **Exercise 7 (auditing):** `AuditorAwareImpl` returns a fixed `"system"`
  string because this project doesn't wire up Spring Security. Swap in a
  `SecurityContextHolder`-based lookup for a real authenticated-user value.
- **Named queries (Exercise 5):** defined via `@NamedQueries` on the
  `Employee` entity and referenced from `EmployeeRepository` with
  `@Query(name = "Employee.findByDepartmentName")` — Spring Data JPA resolves
  the name against the entity's named-query registry.

## Running it

```bash
mvn spring-boot:run
```

`data.sql` seeds 3 departments and 5 employees on startup (`ddl-auto=update`
+ `spring.jpa.defer-datasource-initialization=true` so Hibernate creates the
tables before the seed script runs).

H2 console: `http://localhost:8080/h2-console` — JDBC URL `jdbc:h2:mem:testdb`,
user `sa`, password `password`.

### Example requests

```bash
curl http://localhost:8080/api/employees
curl http://localhost:8080/api/employees/search?name=an
curl http://localhost:8080/api/employees/by-department-name?departmentName=Engineering
curl "http://localhost:8080/api/employees/page?page=0&size=2&sortBy=name"
curl http://localhost:8080/api/employees/department/1/summary
curl http://localhost:8080/api/employees/department/1/view
```
