package com.test.atm.mapper;

import com.test.atm.dao.UserRepository;
import com.test.atm.model.Account;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AccountMapper implements RowMapper<Account> {

    private final UserRepository userRepository;

    public AccountMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        return Account.builder()
                .id(resultSet.getLong("id"))
                .user(userRepository.findById(resultSet.getLong("user_id")))
                .accountNumber(resultSet.getLong("account_number"))
                .amountOfMoney(resultSet.getBigDecimal("amount"))
                .build();
    }
}
