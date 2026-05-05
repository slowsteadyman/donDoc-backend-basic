package com.dondoc.upgrade.practice.repository;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    private final JdbcTemplate jdbcTemplate;

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> findRecords() {
        return jdbcTemplate.queryForList("SELECT * FROM records");
    }

    public List<Map<String, Object>> findCategories() {
        return jdbcTemplate.queryForList("SELECT * FROM categories");
    }

    public List<Map<String, Object>> findMonthlyHistories() {
        return jdbcTemplate.queryForList("SELECT * FROM monthly_history");
    }
}
