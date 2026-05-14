package com.dondoc.upgrade.practice.repository;

import com.dondoc.upgrade.practice.entity.MonthlyHistoryEntity;
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
public class MonthlyHistoryRepository {
    private final JdbcTemplate jdbcTemplate;

    public MonthlyHistoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<MonthlyHistoryEntity> findAll() {
        return jdbcTemplate.query(
            "SELECT * FROM monthly_history",
            new BeanPropertyRowMapper<>(MonthlyHistoryEntity.class)
        );
    }

    public MonthlyHistoryEntity findById(int id) {
        try {
            return jdbcTemplate.queryForObject(
                "SELECT * FROM monthly_history WHERE id = ?",
                new BeanPropertyRowMapper<>(MonthlyHistoryEntity.class),
                id
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public MonthlyHistoryEntity save(MonthlyHistoryEntity monthlyHistory) {
        if (findById(monthlyHistory.getId()) == null) {
            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update(con -> {
                PreparedStatement ps = con.prepareStatement(
                    """
                    INSERT INTO monthly_history (user_id, target_month, avg_ratio, house_level)
                    VALUES (?, ?, ?, ?)
                    """,
                    Statement.RETURN_GENERATED_KEYS
                );
                ps.setInt(1, monthlyHistory.getUserId());
                ps.setObject(2, monthlyHistory.getTargetMonth());
                ps.setDouble(3, monthlyHistory.getAvgRatio());
                ps.setInt(4, monthlyHistory.getHouseLevel());
                return ps;
            }, keyHolder);

            int generatedId = keyHolder.getKey().intValue();
            return findById(generatedId);
        } else {
            jdbcTemplate.update(
                """
                UPDATE monthly_history
                SET user_id = ?, target_month = ?, avg_ratio = ?, house_level = ?
                WHERE id = ?
                """,
                monthlyHistory.getUserId(),
                monthlyHistory.getTargetMonth(),
                monthlyHistory.getAvgRatio(),
                monthlyHistory.getHouseLevel(),
                monthlyHistory.getId()
            );
            return findById(monthlyHistory.getId());
        }
    }
}
