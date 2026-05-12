package com.dondoc.upgrade.practice.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MonthlyHistoryRepository {
    private final JdbcTemplate jdbcTemplate;

    public MonthlyHistoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
