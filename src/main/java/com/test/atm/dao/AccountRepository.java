package com.test.atm.dao;

import com.test.atm.model.Account;

public interface AccountRepository {

    void changeAmountOfMoney(Long amount);

    Account getAccountByUsername(Integer username);
}
