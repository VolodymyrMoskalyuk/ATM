package com.test.atm.dao.impl;

import com.test.atm.dao.UserRepository;
import com.test.atm.mapper.UserMapper;
import com.test.atm.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final UserMapper userMapper;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate, UserMapper userMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.userMapper = userMapper;
    }

    @Override
    public User findByUsername(Integer username) {
        String query = "SELECT * FROM users WHERE username=?";
        return jdbcTemplate.queryForObject(query, userMapper, username);
    }
}
