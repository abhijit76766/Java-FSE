package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Hands on 2 (doc 2): stock Query Methods.
 */
@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Transactional
    public List<Stock> getStockInRange(String code, LocalDate start, LocalDate end) {
        return stockRepository.findByCodeAndDateBetween(code, start, end);
    }

    @Transactional
    public List<Stock> getStockAbovePrice(String code, BigDecimal price) {
        return stockRepository.findByCodeAndCloseGreaterThan(code, price);
    }

    @Transactional
    public List<Stock> getTopVolumeDays(String code) {
        return stockRepository.findTop3ByCodeOrderByVolumeDesc(code);
    }

    @Transactional
    public List<Stock> getLowestCloseDays(String code) {
        return stockRepository.findTop3ByCodeOrderByCloseAsc(code);
    }
}
