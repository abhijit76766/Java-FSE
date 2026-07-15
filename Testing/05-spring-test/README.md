# 05 - Spring Testing Exercises

Spring Boot Maven project (Web + Data JPA + H2 + Test starter).
Run with `mvn test`.

- **Exercise 1:** `CalculatorService` + `CalculatorServiceTest` — plain
  unit test, no Spring context needed.
- **Exercise 2:** `UserServiceTest` — `@Mock`/`@InjectMocks` with
  `MockitoExtension` to mock `UserRepository`.
- **Exercise 3:** `UserControllerTest` — `@WebMvcTest` + `MockMvc` +
  `@MockBean` to test the `/users/{id}` endpoint in isolation.
- **Exercise 4:** `UserIntegrationTest` — `@SpringBootTest` +
  `@AutoConfigureMockMvc`, full flow through the real (H2 in-memory)
  database.
- **Exercise 5:** `UserControllerTest#testCreateUser_returnsCreatedUser`
  — POST endpoint test.
- **Exercise 6:** `UserServiceTest#testGetUserByIdOrThrow_notFound_throwsException`
  — service exception handling.
- **Exercise 7:** `UserRepositoryTest` — `@DataJpaTest` for the custom
  `findByName` query method.
- **Exercise 8:** `UserControllerTest#testGetUserOrThrow_notFound_returns404`
  — `@ControllerAdvice`/`GlobalExceptionHandler` returns 404.
- **Exercise 9:** `CalculatorServiceParameterizedTest` — `@ParameterizedTest`
  with `@CsvSource`.
