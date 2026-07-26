# spring-learn

Solutions for:
- `1__spring-rest-handson.docx` — Spring Core basics, XML bean config, scopes
- `2__spring-rest-handson.docx` — RESTful Web Services (GET), MockMvc testing
- `3__spring-rest-handson.docx` — Employee/Department REST services
- `4__spring-rest-handson.docx` — POST/PUT/DELETE, validation, global exception handling
- `5__JWT-handson.docx` — Spring Security + JWT authentication

One project, since each doc builds directly on the "spring-learn" application
created in doc 1's Hands on 1 — matching how the hands-on itself is written.

## Mapping exercises → code

| Doc | Hands on | Feature | Where |
|---|---|---|---|
| 1 | 1 | Spring Boot project setup | `pom.xml`, `SpringLearnApplication.java` |
| 1 | 2 | Load `SimpleDateFormat` from XML | `resources/date-format.xml`, `SpringLearnApplication#displayDate` |
| 1 | 3 | Logging conventions (info Start/End, debug values) | `application.properties`, used throughout every class |
| 1 | 4 | Load `Country` bean from XML | `resources/country.xml`, `model/Country.java`, `SpringLearnApplication#displayCountry` |
| 1 | 5 | Singleton vs prototype scope | `SpringLearnApplication#demonstrateScopes` (toggle `scope="prototype"` on the `country` bean in `country.xml` to see the difference) |
| 1 | 6 | Load `List<Country>` from XML | `country.xml` (`countryList` bean), `SpringLearnApplication#displayCountries` |
| 2 | — | Hello World REST service | `controller/HelloController.java` |
| 2 | — | Country web service, get all, get by code, exception handling | `controller/CountryController.java`, `service/CountryService.java`, `service/exception/CountryNotFoundException.java` |
| 2 | — | MockMvc tests | `src/test/java/.../SpringLearnApplicationTests.java` |
| 3 | — | Static employee/department data + DAOs | `resources/employee.xml`, `dao/EmployeeDao.java`, `dao/DepartmentDao.java` |
| 3 | — | Employee/Department REST services | `service/EmployeeService.java`, `service/DepartmentService.java`, `controller/EmployeeController.java`, `controller/DepartmentController.java` |
| 4 | — | REST naming standards, `@RequestBody`/`@Valid` | `controller/CountryController.java` (`@RequestMapping("/countries")`) |
| 4 | — | Bean validation annotations | `model/Country.java`, `model/Employee.java`, `model/Department.java`, `model/Skill.java` |
| 4 | — | Global exception handling | `controller/GlobalExceptionHandler.java` |
| 4 | — | Update/delete employee | `EmployeeController`, `EmployeeService`, `EmployeeDao` |
| 5 | — | Basic Auth + in-memory users/roles | `security/SecurityConfig.java` |
| 5 | — | JWT authentication endpoint | `controller/AuthenticationController.java` |
| 5 | — | JWT authorization filter | `security/JwtAuthorizationFilter.java` |

## Adaptations from the original hands-on

- **`/country` → `/countries/india`:** doc 2 first creates a singular
  `/country` endpoint, then doc 4 requires the plural, resource-based naming
  convention (`/countries`) for everything. Rather than keep two competing
  conventions, the single-India-country lookup was kept as
  `GET /countries/india` and every other Country operation follows the
  `/countries` convention from the start (all-countries, by-code, add).
- **Country POST validation:** doc 4 first shows a manual
  `ValidatorFactory`/`Validator` approach, then immediately supersedes it with
  `@Valid` + a global `@ControllerAdvice` exception handler ("This
  disadvantage will be overcome in the next hands on"). Only the final,
  superseding approach is implemented here.
- **`WebSecurityConfigurerAdapter`** is deprecated starting Spring Security
  5.7 (still functional under Spring Boot 2.7, used here) and removed
  entirely in Spring Security 6 / Spring Boot 3. Migrating means replacing
  `SecurityConfig` with a `SecurityFilterChain` `@Bean` instead of extending
  the adapter class.
- **JWT + Java 11:** the `jjwt 0.9.x` library used in the doc calls
  `javax.xml.bind.DatatypeConverter` internally, which was removed from the
  JDK itself in Java 11. `pom.xml` adds `jaxb-api`/`jaxb-runtime` as regular
  dependencies to restore it — otherwise you'd hit a `NoClassDefFoundError`
  the first time a token is generated or parsed.
- **`SpringLearnApplicationTests`** adds `@WithMockUser` to the MockMvc
  tests, since doc 2 writes them before Spring Security is introduced in
  doc 5 — without it, every MockMvc request built against the finished
  project would be rejected with 401 before reaching the controller.

## Running it

```bash
mvn spring-boot:run
```

The app starts on port **8090** (`server.port` in `application.properties`,
matching doc 4/5's curl examples).

### Try it

```bash
# Get a JWT (Basic Auth credentials: user/pwd or admin/pwd)
curl -s -u user:pwd http://localhost:8090/authenticate

# Use the token for any other endpoint
curl -s -H "Authorization: Bearer <token from above>" http://localhost:8090/countries

curl -s -H "Authorization: Bearer <token>" http://localhost:8090/employees
curl -s -H "Authorization: Bearer <token>" http://localhost:8090/departments

curl -i -H "Authorization: Bearer <token>" -H 'Content-Type: application/json' \
  -X POST -d '{"code":"IN","name":"India"}' http://localhost:8090/countries
```

## Note on verification

Written and reviewed by hand in a sandboxed environment without access to
Maven Central, so `mvn` was not run here to confirm a clean build. Run `mvn
clean verify` locally before treating this as a finished, tested deliverable.
