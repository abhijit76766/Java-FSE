# 07 - Logging using SLF4J

Maven project (SLF4J + Logback). Run any example with:
```
mvn compile exec:java -Dexec.mainClass="com.example.logging.LoggingExample"
```
(swap the class name for the other exercises)

- **Exercise 1:** `LoggingExample` — basic `logger.error()` /
  `logger.warn()` calls.
- **Exercise 2:** `ParameterizedLoggingExample` — `{}` placeholder
  logging with one and multiple arguments, plus logging an exception
  alongside a parameterized message.
- **Exercise 3:** `logback.xml` defines a `console` appender and a
  `file` appender (writing to `app.log`), both attached to the root
  logger at `debug` level. `MultiAppenderLoggingExample` demonstrates
  a log line landing in both destinations at once.
