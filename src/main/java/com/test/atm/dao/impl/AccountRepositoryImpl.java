package com.test.atm.dao.impl;

import com.test.atm.dao.AccountRepository;
import com.test.atm.model.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Override
    public void changeAmountOfMoney(Long amount) {
    }

    @Override
    public Account getAccountByUsername(Integer username) {
        return null;
    }
}
