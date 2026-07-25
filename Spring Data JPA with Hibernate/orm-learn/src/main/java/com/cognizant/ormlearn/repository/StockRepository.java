package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Hands on 2 (doc 2): Query Methods on the stock table.
 */
@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    // All stock rows for a code between two dates (e.g. Facebook, Sep 2019).
    List<Stock> findByCodeAndDateBetween(String code, LocalDate start, LocalDate end);

    // All rows for a code where the close price is greater than a threshold.
    List<Stock> findByCodeAndCloseGreaterThan(String code, BigDecimal close);

    // Top 3 rows for a code ordered by volume, descending.
    List<Stock> findTop3ByCodeOrderByVolumeDesc(String code);

    // Bottom 3 rows for a code ordered by close price, ascending.
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
