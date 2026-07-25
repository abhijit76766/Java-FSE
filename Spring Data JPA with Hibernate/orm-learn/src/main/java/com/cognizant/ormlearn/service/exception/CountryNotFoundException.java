package com.cognizant.ormlearn.service.exception;

/**
 * Hands on 6 (doc 1): thrown by CountryService.findCountryByCode() when
 * no country exists for the given code.
 */
public class CountryNotFoundException extends Exception {

    public CountryNotFoundException(String countryCode) {
        super("Country not found for code: " + countryCode);
    }
}
