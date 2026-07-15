# Testing

Solutions for the JUnit / Mockito / Spring Test / SLF4J hands-on lab
exercises. Each numbered folder is a standalone Maven project
(`pom.xml`, `src/main`, `src/test`) containing the completed solution
for that lab, plus a README explaining what's covered.

| # | Folder | Topic |
|---|--------|-------|
| 1 | 01-junit-basic | JUnit setup, basic tests, assertions, AAA pattern, setup/teardown |
| 2 | 02-junit-advanced | Parameterized tests, test suites, execution order, exception & timeout testing |
| 3 | 03-mockito-basic | Mocking/stubbing, verifying interactions, argument matching, void methods, multiple returns, interaction order |
| 4 | 04-mockito-advanced | Mocking repositories, REST clients, file I/O, network clients |
| 5 | 05-spring-test | Spring Boot service/controller/repository unit + integration tests (MockMvc, @DataJpaTest, @SpringBootTest) |
| 6 | 06-mockito-spring-dependencies | Mocking service/repository dependencies in Spring controller, service, and integration tests |
| 7 | 07-slf4j-logging | SLF4J + Logback: log levels, parameterized logging, multiple appenders |

## Running any exercise

```
cd <exercise-folder>
mvn test
```

Exercise 7 (logging) has no tests — run its `main` classes instead
(see its own README).
