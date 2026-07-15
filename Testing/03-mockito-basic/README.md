# 03 - Mockito Hands-On Exercises

Maven project (JUnit 5 + Mockito). Run with `mvn test`.

- **Exercise 1 (Mocking and Stubbing):** `ExternalApi` + `MyService` +
  `MyServiceTest#testExternalApi`.
- **Exercise 2 (Verifying Interactions):** `MyServiceTest#testVerifyInteraction`.
- **Exercise 3 (Argument Matching):** `GreetingService` + `Greeter` +
  `ArgumentMatchingTest`, using `eq()` and `anyString()`.
- **Exercise 4 (Void Methods):** `AuditLogger` + `AuditingService` +
  `AuditingServiceTest`, using `doNothing()`.
- **Exercise 5 (Multiple Returns):** `MultipleReturnsTest`, using
  chained `thenReturn()`.
- **Exercise 6 (Interaction Order):** `OrderService` +
  `InteractionOrderTest`, using `InOrder`.
- **Exercise 7 (Void Methods with Exceptions):**
  `AuditingServiceTest#testPerformAction_whenLoggerThrows_exceptionPropagates`,
  using `doThrow()`.
