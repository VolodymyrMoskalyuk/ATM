package com.test.atm.dao;

import com.test.atm.model.Account;

public interface AccountRepository {

    void updateAccount(Account account);

    Account getAccountByAccountNumber(Long accountNumber);

}
