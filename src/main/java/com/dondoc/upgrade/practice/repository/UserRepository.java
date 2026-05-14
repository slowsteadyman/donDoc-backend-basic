package com.dondoc.upgrade.practice.repository;

import com.dondoc.upgrade.practice.entity.UserEntity;
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
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<UserEntity> findAll() {
        return jdbcTemplate.query(
            "SELECT * FROM users",
            new BeanPropertyRowMapper<>(UserEntity.class)
        );
    }

    public UserEntity findById(int id) {
        try {
            return jdbcTemplate.queryForObject(
                "SELECT * FROM users WHERE id = ?",
                new BeanPropertyRowMapper<>(UserEntity.class),
                id
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public UserEntity save(UserEntity user) {
        if (findById(user.getId()) == null) {
            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update(con -> {
                PreparedStatement ps = con.prepareStatement(
                    """
                    INSERT INTO users (user_id, user_password, name, age, current_pig_level, current_house_level, monthly_income, target_expense_ratio, created_at)
                    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                    """,
                    Statement.RETURN_GENERATED_KEYS
                );
                ps.setString(1, user.getUserId());
                ps.setString(2, user.getUserPassword());
                ps.setString(3, user.getName());
                ps.setInt(4, user.getAge());
                ps.setInt(5, user.getCurrentPigLevel());
                ps.setInt(6, user.getCurrentHouseLevel());
                ps.setInt(7, user.getMonthlyIncome());
                ps.setDouble(8, user.getTargetExpenseRatio());
                ps.setObject(9, user.getCreatedAt());
                return ps;
            }, keyHolder);

            int generatedId = keyHolder.getKey().intValue();
            return findById(generatedId);
        } else {
            jdbcTemplate.update(
                """
                UPDATE users
                SET user_id = ?, user_password = ?, name = ?, age = ?, current_pig_level = ?, current_house_level = ?, monthly_income = ?, target_expense_ratio = ?, created_at = ?
                WHERE id = ?
                """,
                user.getUserId(),
                user.getUserPassword(),
                user.getName(),
                user.getAge(),
                user.getCurrentPigLevel(),
                user.getCurrentHouseLevel(),
                user.getMonthlyIncome(),
                user.getTargetExpenseRatio(),
                user.getCreatedAt(),
                user.getId()
            );
            return findById(user.getId());
        }
    }
}