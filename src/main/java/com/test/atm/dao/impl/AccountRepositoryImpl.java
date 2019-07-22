package com.test.atm.dao.impl;

import com.test.atm.dao.AccountRepository;
import com.test.atm.mapper.AccountMapper;
import com.test.atm.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    private final JdbcTemplate jdbcTemplate;
    private final AccountMapper AccountMapper;

    public AccountRepositoryImpl(JdbcTemplate jdbcTemplate, AccountMapper accountMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.AccountMapper = accountMapper;
    }

    @Override
    public void updateAccount(Account account) {
        String query = "UPDATE account SET amount=? WHERE account_number=?";
        jdbcTemplate.update(query, account.getAmountOfMoney(), account.getAccountNumber());
    }

    @Override
    public Account getAccountByAccountNumber(Long accountNumber) {
        String query = "SELECT * FROM users WHERE account_number=?";
        return jdbcTemplate.queryForObject(query, AccountMapper, accountNumber);
    }
}
