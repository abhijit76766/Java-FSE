package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * doc 2: "REST - Country Web Service" (/country), "REST - Get all countries"
 * (/countries), "REST - Get country based on country code" (/countries/{code}),
 * "REST - Get country exceptional scenario".
 * doc 4: RESTful naming standards - class-level @RequestMapping("/countries"),
 * POST with @RequestBody @Valid (validation errors handled by
 * GlobalExceptionHandler instead of a manual ValidatorFactory - see its
 * class comment for why).
 */
@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    public CountryController() {
        LOGGER.debug("Inside CountryController Constructor.");
    }

    // doc 2's original "/country" single-resource endpoint, kept for parity
    // with that hands-on; the /countries endpoints below are the version
    // brought in line with doc 4's naming standards.
    @GetMapping("/india")
    public Country getCountryIndia() {
        LOGGER.info("Start");
        Country country = countryService.getCountryIndia();
        LOGGER.info("End");
        return country;
    }

    @GetMapping
    public List<Country> getAllCountries() {
        LOGGER.info("Start");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.info("End");
        return countries;
    }

    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        LOGGER.info("Start");
        Country country = countryService.getCountry(code);
        LOGGER.info("End");
        return country;
    }

    @PostMapping
    public Country addCountry(@RequestBody @Valid Country country) {
        LOGGER.info("Start");
        LOGGER.debug("country:{}", country);
        LOGGER.info("End");
        return country;
    }
}
