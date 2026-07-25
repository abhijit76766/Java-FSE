package com.cognizant.ormlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hands on 1 (doc 1): Spring Data JPA - Quick Example, entry point.
 *
 * The original hands-on wires up test methods directly in main() using a
 * static ApplicationContext reference. This has been re-implemented as a
 * @Component CommandLineRunner (see runner/DemoRunner.java) so every hands-on
 * scenario still runs automatically on startup, using idiomatic Spring Boot
 * wiring instead of static service references.
 */
@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Inside main");
        SpringApplication.run(OrmLearnApplication.class, args);
    }
}
