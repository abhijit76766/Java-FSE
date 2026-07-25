package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Hands on 1 (doc 2): Query Methods on the country table.
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // Search-as-you-type: all countries whose name contains the given text.
    List<Country> findByNameContainingIgnoreCase(String text);

    // Same search, but results ordered alphabetically ascending.
    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String text);

    // Alphabet index: all countries whose name starts with the given letter.
    List<Country> findByNameStartingWithIgnoreCase(String letter);
}
