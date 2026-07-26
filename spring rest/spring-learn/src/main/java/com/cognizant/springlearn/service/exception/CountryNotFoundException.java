package com.cognizant.springlearn.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Hands on "REST - Get country exceptional scenario" (doc 2).
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Country not found")
public class CountryNotFoundException extends Exception {

    public CountryNotFoundException(String code) {
        super("Country not found for code: " + code);
    }
}
