package com.cognizant.ems.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * Exercise 7: supplies the value used for @CreatedBy/@LastModifiedBy.
 *
 * No Spring Security is wired into this sample project, so this returns a
 * fixed placeholder. In a real application, replace the body with something
 * like:
 *
 *   Authentication auth = SecurityContextHolder.getContext().getAuthentication();
 *   return Optional.ofNullable(auth).map(Authentication::getName);
 */
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("system");
    }
}
