# orm-learn

Solutions for the hands-on exercises in:
- `1__spring-data-jpa-handson.docx` — ORM basics, Country CRUD
- `2__spring-data-jpa-handson.docx` — Query Methods, entity relationships
- `3__spring-data-jpa-handson.docx` — HQL/JPQL, Native Query, Criteria Query

## Adaptations from the original hands-on

- **Database:** the docs target MySQL (`ormlearn` schema). This project uses
  the embedded **H2** database instead so it builds and runs with no external
  setup. The commented-out MySQL configuration is left in `application.properties`
  and `pom.xml` for anyone who wants to follow the original steps exactly.
- **Test methods → CommandLineRunner:** the docs wire up `test*()` methods by
  hand from a static `main()`. `runner/DemoRunner.java` runs the same
  scenarios automatically on startup via Spring's `CommandLineRunner`, which
  is the idiomatic Spring Boot equivalent.
- **Hands on 3 (doc 3) — quiz attempt HQL:** this exercise depends on a
  proprietary `quiz.mwb` MySQL Workbench schema file referenced in the
  original doc, which wasn't provided alongside it, so it isn't implemented
  here. The approach (join `user → attempt → attempt_question → question →
  attempt_option → options` with `fetch` on every one-to-many hop) is the
  same technique demonstrated in Hands on 2.
- **Hands on 2/3 (doc 1) — Hibernate XML/Annotation config walkthroughs:**
  these are explanation-only exercises pointing at TutorialsPoint sample code
  (no feature to implement), so there's nothing to build for them here.

## What's implemented

| Doc | Hands on | Feature | Where |
|---|---|---|---|
| 1 | 1 | Country entity, repository, service, quick example | `model/Country.java`, `repository/CountryRepository.java`, `service/CountryService.java` |
| 1 | 4 | Hibernate vs Spring Data JPA comparison | see doc; `EmployeeService`/`EmployeeRepository` show the Spring Data JPA side |
| 1 | 5-9 | Country CRUD (find/add/update/delete) | `service/CountryService.java` |
| 2 | 1 | Query Methods: contains/sorted/starts-with | `repository/CountryRepository.java` |
| 2 | 2 | Query Methods on stock data | `model/Stock.java`, `repository/StockRepository.java`, `service/StockService.java` |
| 2 | 3 | Payroll schema + bean mapping (Employee/Department/Skill) | `model/*.java` |
| 2 | 4 | `@ManyToOne` Employee → Department | `model/Employee.java` |
| 2 | 5 | `@OneToMany` Department → Employee | `model/Department.java` |
| 2 | 6 | `@ManyToMany` Employee ↔ Skill | `model/Employee.java`, `model/Skill.java` |
| 3 | 1 | HQL vs JPQL (explanation) | this README |
| 3 | 2 | HQL with `@Query`, `fetch` to avoid N+1 / lazy exceptions | `repository/EmployeeRepository.java` |
| 3 | 4 | Average salary (HQL aggregate, with/without department filter) | `repository/EmployeeRepository.java` |
| 3 | 5 | Native query | `repository/EmployeeRepository.java` |
| 3 | 6 | Criteria Query dynamic search | `service/EmployeeService.java#searchEmployees` |

## Running it

```bash
mvn spring-boot:run
```

`DemoRunner` (a `CommandLineRunner`) executes every hands-on scenario on
startup and logs the results — watch the console for `DEBUG` lines such as
`Country:{...}`, `Permanent Employees:{...}`, `Average salary...`.

H2 console (optional, while the app is running): `http://localhost:8080/h2-console`
JDBC URL: `jdbc:h2:mem:ormlearn`, user `sa`, empty password.

## Notes worth remembering (called out in the original doc)

- **`@ManyToOne` default fetch = EAGER, `@OneToMany`/`@ManyToMany` default
  fetch = LAZY** (per the JPA spec). Fetching a lazy collection outside an
  open Hibernate session raises `LazyInitializationException` — this project
  sets `fetch = FetchType.EAGER` on those collections to sidestep it, exactly
  as the hands-on does, at the cost of always loading the association.
- **`join` vs `join fetch` in HQL:** `join` only links tables for filtering;
  it does not populate the associated Java object. `join fetch` populates it.
  See `EmployeeRepository.getAllPermanentEmployees()`.
- **Native queries** are direct SQL and bypass the database abstraction HQL
  gives you — use them sparingly, only when HQL/JPQL genuinely can't express
  the query.
