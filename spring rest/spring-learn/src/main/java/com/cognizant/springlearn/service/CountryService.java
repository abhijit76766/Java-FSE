package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Hands on "REST - Get all countries" / "REST - Get country based on country
 * code" / "REST - Get country exceptional scenario" (doc 2).
 */
@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    public Country getCountryIndia() {
        LOGGER.info("Start");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = (Country) context.getBean("country", Country.class);
        LOGGER.info("End");
        return country;
    }

    @SuppressWarnings("unchecked")
    public List<Country> getAllCountries() {
        LOGGER.info("Start");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countries = (List<Country>) context.getBean("countryList", ArrayList.class);
        LOGGER.debug("countries.size={}", countries.size());
        LOGGER.info("End");
        return countries;
    }

    // Case-insensitive match, per doc 2's requirement, using a lambda instead
    // of a manual iteration loop (the doc explicitly allows either).
    public Country getCountry(String code) throws CountryNotFoundException {
        LOGGER.info("Start");
        Country match = getAllCountries().stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new CountryNotFoundException(code));
        LOGGER.debug("Country:{}", match);
        LOGGER.info("End");
        return match;
    }
}
