# 01 - JUnit Basic Testing Exercises

Maven project (JUnit 5 / Jupiter). Run with `mvn test`.

- **Exercise 1 (Setting up JUnit):** see `pom.xml` — JUnit Jupiter
  added as a `test`-scoped dependency (JUnit 5 equivalent of the
  JUnit 4 `pom.xml` snippet in the exercise).
- **Exercise 2 (Basic tests):** `Calculator.java` + `CalculatorTest.java`
  — add/subtract/multiply/divide methods, each with a test.
- **Exercise 3 (Assertions):** `AssertionsTest.java` — `assertEquals`,
  `assertTrue`, `assertFalse`, `assertNull`, `assertNotNull`.
- **Exercise 4 (AAA pattern + setup/teardown):** `CalculatorAAATest.java`
  — `@BeforeEach`/`@AfterEach` (JUnit 5 names for `@Before`/`@After`)
  set up and tear down a fresh `Calculator` fixture per test; each
  test body is commented with its Arrange / Act / Assert sections.
