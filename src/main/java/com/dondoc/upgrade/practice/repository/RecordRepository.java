package com.dondoc.upgrade.practice.repository;

import com.dondoc.upgrade.practice.entity.RecordEntity;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class RecordRepository {
    private final JdbcTemplate jdbcTemplate;

    public RecordRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<RecordEntity> findAll() {
        return jdbcTemplate.query(
            "SELECT * FROM records",
            new BeanPropertyRowMapper<>(RecordEntity.class)
        );
    }

    public RecordEntity findById(int id) {
        try {
            return jdbcTemplate.queryForObject(
                "SELECT * FROM records WHERE id = ?",
                new BeanPropertyRowMapper<>(RecordEntity.class),
                id
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public RecordEntity save(RecordEntity record) {
        if (findById(record.getId()) == null) {
            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update(con -> {
                PreparedStatement ps = con.prepareStatement(
                    """
                    INSERT INTO records (user_id, category_id, amount, description, memo, record_date, created_at)
                    VALUES (?, ?, ?, ?, ?, ?, ?)
                    """,
                    Statement.RETURN_GENERATED_KEYS
                );
                ps.setInt(1, record.getUserId());
                ps.setInt(2, record.getCategoryId());
                ps.setInt(3, record.getAmount());
                ps.setString(4, record.getDescription());
                ps.setString(5, record.getMemo());
                ps.setObject(6, record.getRecordDate());
                ps.setObject(7, record.getCreatedAt());
                return ps;
            }, keyHolder);

            int generatedId = keyHolder.getKey().intValue();
            return findById(generatedId);
        } else {
            jdbcTemplate.update(
                """
                UPDATE records
                SET user_id = ?, category_id = ?, amount = ?, description = ?, memo = ?, record_date = ?, created_at = ?
                WHERE id = ?
                """,
                record.getUserId(),
                record.getCategoryId(),
                record.getAmount(),
                record.getDescription(),
                record.getMemo(),
                record.getRecordDate(),
                record.getCreatedAt(),
                record.getId()
            );
            return findById(record.getId());
        }
    }
}
