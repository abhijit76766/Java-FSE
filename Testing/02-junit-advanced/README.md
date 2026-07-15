# 02 - Advanced JUnit Testing Exercises

Maven project (JUnit 5 / Jupiter). Run with `mvn test`.

- **Exercise 1:** `EvenChecker` + `EvenCheckerTest` using
  `@ParameterizedTest` and `@ValueSource`.
- **Exercise 2:** `AllTests` suite using `@Suite` + `@SelectClasses`
  (JUnit Platform Suite engine) to group the other test classes.
- **Exercise 3:** `OrderedTests` using `@TestMethodOrder` +
  `@Order` to control execution order.
- **Exercise 4:** `ExceptionThrower` + `ExceptionThrowerTest` using
  `assertThrows` to verify the expected exception and its message.
- **Exercise 5:** `PerformanceTester` + `PerformanceTesterTest` using
  `assertTimeout` to enforce a time limit.
