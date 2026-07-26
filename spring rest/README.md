# Spring REST — Hands-on Solutions

Solved code for:

- `1__spring-rest-handson.docx`
- `2__spring-rest-handson.docx`
- `3__spring-rest-handson.docx`
- `4__spring-rest-handson.docx`
- `5__JWT-handson.docx`

All five build on a single Maven/Spring Boot project, [`spring-learn/`](./spring-learn),
since each doc extends the same application created in doc 1's first
hands-on exercise (Spring Core → RESTful Web Services → validation/exception
handling → Spring Security + JWT).

See [`spring-learn/README.md`](./spring-learn/README.md) for the full
exercise-by-exercise map of what was implemented and where, plus notes on
adaptations made from the original docs (naming convention consolidation,
`WebSecurityConfigurerAdapter` deprecation, a Java 11 fix needed for the JWT
library).

## Requirements

- JDK 11+
- Maven 3.6+

## Running it

```bash
cd spring-learn
mvn spring-boot:run
```

## Note on verification

Written and reviewed by hand in a sandboxed environment without access to
Maven Central, so `mvn` was not run here to confirm a clean build. Run `mvn
clean verify` locally before treating this as a finished, tested deliverable.
