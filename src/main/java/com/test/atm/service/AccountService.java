package com.test.atm.service;

import com.test.atm.model.Account;

import java.math.BigDecimal;

public interface AccountService {

    Account getAccountByAccountNumber(Long accountNumber);

    String addMoneyToAccount(BigDecimal amount, Long accountNumber);

    String getMoneyFromAccount(BigDecimal amount, Long accountNumber);

    String transferMoneyToOtherAccount(BigDecimal amount, Long accountNumberFrom, Long accountNumberTo);
}
