package com.test.atm.service.impl;

import com.test.atm.dao.AccountRepository;
import com.test.atm.model.Account;
import com.test.atm.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    private static final String OPERATION_SUCCESSFUL = "Operation successful!!!";
    private static final String NOT_ENOUGH_MONEY = "Not enough money!!!";
    private static final String MULTIPLE = "Enter value multiple of 100, 200, 500";
    private static final String ACCOUNT_DOES_NOT_EXIST = "Account %d doesn`t exist";

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account getAccountByAccountNumber(Long accountNumber) {
        return accountRepository.getAccountByAccountNumber(accountNumber);
    }

    @Override
    @Transactional
    public String addMoneyToAccount(BigDecimal amount, Long accountNumber) {
        Account account = getAccountByAccountNumber(accountNumber);
        if (account != null) {
            if (amount.intValue() % 100 == 0) {
                account.setAmountOfMoney(account.getAmountOfMoney().add(amount));
                accountRepository.updateAccount(account);
                return OPERATION_SUCCESSFUL;
            }
            return MULTIPLE;
        }
        return String.format(ACCOUNT_DOES_NOT_EXIST, accountNumber);
    }

    @Override
    @Transactional
    public String getMoneyFromAccount(BigDecimal amount, Long accountNumber) {
        Account account = getAccountByAccountNumber(accountNumber);
        if (account != null) {
            if (checkIfNeededAmountPresent(amount, account)) {
                if (amount.intValue() % 100 == 0) {
                    account.setAmountOfMoney(account.getAmountOfMoney().subtract(amount));
                    accountRepository.updateAccount(account);
                    return OPERATION_SUCCESSFUL;
                }
                return MULTIPLE;
            }
            return NOT_ENOUGH_MONEY;
        }
        return String.format(ACCOUNT_DOES_NOT_EXIST, accountNumber);
    }

    @Override
    @Transactional
    public String transferMoneyToOtherAccount(BigDecimal amount, Long accountNumberFrom, Long accountNumberTo) {
        Account accountFrom = getAccountByAccountNumber(accountNumberFrom);
        Account accountTo = getAccountByAccountNumber(accountNumberTo);
        if (accountFrom != null) {
            if (checkIfNeededAmountPresent(amount, accountFrom)) {
                if (accountTo != null) {
                    accountFrom.setAmountOfMoney(accountTo.getAmountOfMoney().subtract(amount));
                    accountTo.setAmountOfMoney(accountTo.getAmountOfMoney().add(amount));
                    accountRepository.updateAccount(accountFrom);
                    accountRepository.updateAccount(accountTo);
                    return OPERATION_SUCCESSFUL;
                }
                return String.format(ACCOUNT_DOES_NOT_EXIST, accountNumberTo);
            }
            return NOT_ENOUGH_MONEY;
        }
        return String.format(ACCOUNT_DOES_NOT_EXIST, accountNumberFrom);
    }

    private boolean checkIfNeededAmountPresent(BigDecimal amount, Account account) {
        return account.getAmountOfMoney().subtract(amount).intValue() > 0;
    }
}
