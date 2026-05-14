package com.dondoc.upgrade.practice.repository;

import com.dondoc.upgrade.practice.entity.CategoryEntity;
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
public class CategoryRepository {
    private final JdbcTemplate jdbcTemplate;

    public CategoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CategoryEntity> findAll() {
        return jdbcTemplate.query(
            "SELECT * FROM categories",
            new BeanPropertyRowMapper<>(CategoryEntity.class)
        );
    }

    public CategoryEntity findById(int id) {
        try {
            return jdbcTemplate.queryForObject(
                "SELECT * FROM categories WHERE id = ?",
                new BeanPropertyRowMapper<>(CategoryEntity.class),
                id
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public CategoryEntity save(CategoryEntity category) {
        if (findById(category.getId()) == null) {
            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update(con -> {
                PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO categories (name, icon, type) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
                );
                ps.setString(1, category.getName());
                ps.setString(2, category.getIcon());
                ps.setString(3, category.getType());
                return ps;
            }, keyHolder);

            int generatedId = keyHolder.getKey().intValue();
            return findById(generatedId);
        } else {
            jdbcTemplate.update(
                "UPDATE categories SET name = ?, icon = ?, type = ? WHERE id = ?",
                category.getName(), category.getIcon(), category.getType(), category.getId()
            );
            return findById(category.getId());
        }
    }
}
