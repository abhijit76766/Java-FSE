package com.cognizant.springlearn;

import com.cognizant.springlearn.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Hands on 1 (doc 1): Spring Web project entry point.
 * Hands on 2 (doc 1): displayDate() - load SimpleDateFormat from XML.
 * Hands on 4 (doc 1): displayCountry() - load a Country bean from XML.
 * Hands on 5 (doc 1): demonstrateScopes() - singleton vs prototype scope.
 * Hands on 6 (doc 1): displayCountries() - load a List<Country> from XML.
 */
@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) throws Exception {
        LOGGER.info("Start");
        displayDate();
        displayCountry();
        demonstrateScopes();
        displayCountries();
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("End");
    }

    private static void displayDate() throws Exception {
        LOGGER.info("Start");
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        Date date = format.parse("31/12/2018");
        LOGGER.debug(date.toString());
        LOGGER.info("End");
    }

    private static void displayCountry() {
        LOGGER.info("Start");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = (Country) context.getBean("country", Country.class);
        LOGGER.debug("Country : {}", country.toString());
        LOGGER.info("End");
    }

    // Hands on 5: with the default scope="singleton" in country.xml, the
    // Country constructor log appears once. Change country.xml's "country"
    // bean to scope="prototype" and it will appear twice - once per getBean().
    private static void demonstrateScopes() {
        LOGGER.info("Start");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        Country anotherCountry = context.getBean("country", Country.class);
        LOGGER.debug("country == anotherCountry: {}", country == anotherCountry);
        LOGGER.info("End");
    }

    @SuppressWarnings("unchecked")
    private static void displayCountries() {
        LOGGER.info("Start");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countries = (List<Country>) context.getBean("countryList", ArrayList.class);
        LOGGER.debug("Countries : {}", countries);
        LOGGER.info("End");
    }
}
