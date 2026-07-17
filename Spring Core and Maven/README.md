# Spring Core and Maven Solutions

Solutions for the Spring Core, Maven, AOP, DI, and Spring Boot exercises.

## Projects

- `LibraryManagement` - Classic Maven + Spring Framework XML/annotation/AOP solution for Exercises 1 to 8.
- `LibraryManagementBoot` - Spring Boot REST + JPA + H2 solution for Exercise 9.

## Exercise Mapping

- Exercise 1: `LibraryManagement/pom.xml`, `applicationContext.xml`, `BookService`, `BookRepository`, `LibraryManagementApplication`
- Exercise 2: Setter-based dependency injection in `BookService` and `applicationContext.xml`
- Exercise 3: Spring AOP timing with `LoggingAspect`
- Exercise 4: Maven project configuration with Spring Context, AOP, WebMVC, and compiler plugin
- Exercise 5: Spring IoC container XML configuration
- Exercise 6: Annotation-based beans using `@Service`, `@Repository`, and `applicationContext-annotations.xml`
- Exercise 7: Constructor and setter injection in `applicationContext-constructor-setter.xml`
- Exercise 8: Basic AOP before, after, and around advice in `LoggingAspect`
- Exercise 9: Spring Boot app in `LibraryManagementBoot`

## Build

```bash
cd LibraryManagement
mvn clean package

cd ../LibraryManagementBoot
mvn clean package
```
