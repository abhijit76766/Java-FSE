package com.cognizant.springlearn.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Hands on "Implement REST service for updating an employee" (doc 4).
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Employee not found")
public class EmployeeNotFoundException extends Exception {

    public EmployeeNotFoundException(Long id) {
        super("Employee not found for id: " + id);
    }
}
