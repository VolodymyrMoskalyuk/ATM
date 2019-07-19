package com.test.atm.mapper;

import com.test.atm.model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {

        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setUsername(resultSet.getInt("username"));
        user.setUsername(resultSet.getInt("password"));

        return user;
    }
}
