package com.cognizant.ems.projection;

/**
 * Exercise 8: interface-based projection - Spring Data JPA generates a proxy
 * that only selects the id/name/email columns instead of the full Employee
 * entity (department is deliberately left out).
 */
public interface EmployeeSummary {

    Long getId();

    String getName();

    // @Value can derive a computed property from other projection getters,
    // e.g. exposing the email's domain without a stored column for it.
    @org.springframework.beans.factory.annotation.Value("#{target.email}")
    String getEmail();
}
