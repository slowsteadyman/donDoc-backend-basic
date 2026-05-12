package com.dondoc.upgrade.practice.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FarmMemberRepository {
    private final JdbcTemplate jdbcTemplate;

    public FarmMemberRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
