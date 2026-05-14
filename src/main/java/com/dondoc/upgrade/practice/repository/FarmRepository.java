package com.dondoc.upgrade.practice.repository;

import com.dondoc.upgrade.practice.entity.FarmEntity;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class FarmRepository {
    private final JdbcTemplate jdbcTemplate;

    public FarmRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<FarmEntity> findAll() {
        return jdbcTemplate.query(
            "SELECT * FROM farms",
            new BeanPropertyRowMapper<>(FarmEntity.class)
        );
    }

    public FarmEntity findById(int id) {
        try {
            return jdbcTemplate.queryForObject(
                "SELECT * FROM farms WHERE id = ?",
                new BeanPropertyRowMapper<>(FarmEntity.class),
                id
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public FarmEntity save(FarmEntity farm) {
        if (findById(farm.getId()) == null) {
            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update(con -> {
                PreparedStatement ps = con.prepareStatement(
                    """
                    INSERT INTO farms (name, created_at)
                    VALUES (?, ?)
                    """,
                    Statement.RETURN_GENERATED_KEYS
                );
                ps.setString(1, farm.getName());
                ps.setObject(2, farm.getCreatedAt());
                return ps;
            }, keyHolder);

            int generatedId = keyHolder.getKey().intValue();
            return findById(generatedId);
        } else {
            jdbcTemplate.update(
                """
                UPDATE farms
                SET name = ?, created_at = ?
                WHERE id = ?
                """,
                farm.getName(), farm.getCreatedAt(), farm.getId()
            );
            return findById(farm.getId());
        }
    }
}
