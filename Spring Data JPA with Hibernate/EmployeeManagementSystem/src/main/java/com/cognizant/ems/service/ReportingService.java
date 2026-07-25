package com.cognizant.ems.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Exercise 9: demonstrates reading/writing against the second ("reporting")
 * data source configured in config/DataSourceConfig.java, independent of
 * the primary JPA-backed employee/department database.
 */
@Service
@RequiredArgsConstructor
public class ReportingService {

    private final JdbcTemplate reportingJdbcTemplate;

    @PostConstruct
    public void initReportingSchema() {
        reportingJdbcTemplate.execute(
                "CREATE TABLE IF NOT EXISTS access_log (" +
                        "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                        "endpoint VARCHAR(255), " +
                        "accessed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");
    }

    public void recordAccess(String endpoint) {
        reportingJdbcTemplate.update(
                "INSERT INTO access_log (endpoint) VALUES (?)", endpoint);
    }

    public Long countAccesses(String endpoint) {
        Long count = reportingJdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM access_log WHERE endpoint = ?", Long.class, endpoint);
        return count == null ? 0L : count;
    }
}
