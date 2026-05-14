package com.dondoc.upgrade.practice.repository;

import com.dondoc.upgrade.practice.entity.FarmMemberEntity;
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
public class FarmMemberRepository {
    private final JdbcTemplate jdbcTemplate;

    public FarmMemberRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<FarmMemberEntity> findAll() {
        return jdbcTemplate.query(
            "SELECT * FROM farm_members",
            new BeanPropertyRowMapper<>(FarmMemberEntity.class)
        );
    }

    public FarmMemberEntity findById(int id) {
        try {
            return jdbcTemplate.queryForObject(
                "SELECT * FROM farm_members WHERE id = ?",
                new BeanPropertyRowMapper<>(FarmMemberEntity.class),
                id
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public FarmMemberEntity save(FarmMemberEntity farmMember) {
        if (findById(farmMember.getId()) == null) {
            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update(con -> {
                PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO farm_members (user_id, farm_id)",
                    Statement.RETURN_GENERATED_KEYS
                );
                ps.setInt(1, farmMember.getFarmId());
                ps.setInt(2, farmMember.getFarmId());
                ps.setObject(3, farmMember.getJoinedAt());
                return ps;
            }, keyHolder);

            int generatedId = keyHolder.getKey().intValue();
            return findById(generatedId);

        } else {
            jdbcTemplate.update(
                "UPDATE farm_members SET user_id = ?, farm_id = ?, joined_at = ? WHERE id = ?",
                farmMember.getUserId(), farmMember.getFarmId(), farmMember.getJoinedAt(), farmMember.getId()
            );
            return findById(farmMember.getId());
        }
    }
}
