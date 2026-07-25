package com.cognizant.ems.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Exercise 9: Customizing Data Source Configuration / managing multiple
 * data sources.
 *
 * The primary data source (employee/department data) is left to Spring
 * Boot's auto-configuration, driven by the plain spring.datasource.* keys in
 * application.properties (Exercise 9's "Spring Boot Auto-Configuration"
 * requirement).
 *
 * The second, "reporting", data source is externalized under its own
 * reporting.datasource.* prefix and exposed as a plain DataSource here. It's
 * deliberately kept as a DataSource/JdbcTemplate rather than a second full
 * JPA EntityManagerFactory + TransactionManager pair (which needs separate
 * @EnableJpaRepositories base packages, entity manager factory beans, and
 * transaction managers) to keep this example focused on the data-source
 * externalization the exercise asks for. See ReportingService for how it's
 * used, and README.md for how to extend this into a full second
 * EntityManagerFactory if you need JPA against the second database too.
 */
@Configuration
public class DataSourceConfig {

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "reporting.datasource")
    public DataSource reportingDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public JdbcTemplate reportingJdbcTemplate() {
        return new JdbcTemplate(reportingDataSource());
    }
}
