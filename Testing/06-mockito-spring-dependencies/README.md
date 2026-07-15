# 06 - Mocking Dependencies in Spring Tests using Mockito

Spring Boot Maven project. Run with `mvn test`.

- **Exercise 1:** `UserControllerTest` — `@WebMvcTest` + `@MockBean`
  mocks the `UserService` dependency of `UserController`.
- **Exercise 2:** `UserServiceTest` — plain Mockito (`@Mock` +
  `@InjectMocks` via `MockitoExtension`, no Spring context) mocks the
  `UserRepository` dependency of `UserService`.
- **Exercise 3:** `UserIntegrationTest` — `@SpringBootTest` +
  `@AutoConfigureMockMvc` boots the full app context while still
  replacing `UserService` with a `@MockBean`, as hinted in the
  exercise.
