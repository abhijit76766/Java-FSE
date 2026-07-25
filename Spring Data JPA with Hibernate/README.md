# Spring Data JPA & Hibernate — Hands-on Solutions

Solved code for the four hands-on documents:

- `1__spring-data-jpa-handson.docx`
- `2__spring-data-jpa-handson.docx`
- `3__spring-data-jpa-handson.docx`
- `Spring_Data_JPA_and_Hibernate.docx`

Organized as two independent Maven/Spring Boot projects:

| Folder | Covers | Source docs |
|---|---|---|
| [`orm-learn/`](./orm-learn) | ORM basics, Country CRUD, Query Methods, entity relationships (`@ManyToOne`/`@OneToMany`/`@ManyToMany`), HQL/JPQL, Native Query, Criteria Query | docs 1, 2, 3 |
| [`EmployeeManagementSystem/`](./EmployeeManagementSystem) | Entities/repositories/CRUD REST API, custom + named queries, pagination/sorting, entity auditing, projections, multiple data sources, Hibernate-specific batch tuning | doc 4 |

Each folder has its own README with an exercise-by-exercise map of what was
implemented and where, plus any adaptations made from the original doc (both
were originally written against MySQL; both run here against embedded H2 so
they build and run with no external database setup — see each README for the
commented-out MySQL config if you want to follow the docs exactly).

## Requirements

- JDK 11+
- Maven 3.6+

## Running either project

```bash
cd orm-learn                     # or EmployeeManagementSystem
mvn spring-boot:run
```

## Note on verification

These projects were written and reviewed by hand in a sandboxed environment
without access to Maven Central, so `mvn` was not run here to confirm a clean
build. Double-check `mvn clean verify` locally before relying on this as a
finished, tested deliverable.
