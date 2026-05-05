package com.dondoc.upgrade.practice.repository;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FarmRepository {
    private final JdbcTemplate jdbcTemplate;

    public FarmRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> findFarms() {
        return jdbcTemplate.queryForList("SELECT * FROM farms");
    }

    public List<Map<String, Object>> findFarmMembers() {
        return jdbcTemplate.queryForList("SELECT * FROM farm_members");
    }
}
