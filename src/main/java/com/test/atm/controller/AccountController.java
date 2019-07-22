package com.test.atm.controller;

import com.test.atm.model.Account;
import com.test.atm.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping()
    public Account getAccount(@RequestParam Long accountNumber) {
        System.out.println(accountNumber);
        return accountService.getAccountByAccountNumber(accountNumber);
    }

    @PostMapping("/operation/add-money")
    public String addMoneyToAccount(@RequestParam BigDecimal amount, @RequestParam Long accountNumber) {
        return accountService.addMoneyToAccount(amount, accountNumber);
    }

    @PostMapping("/operation/get-money")
    public String getMoneyFromAccount(@RequestParam BigDecimal amount, @RequestParam Long accountNumber) {
        return accountService.getMoneyFromAccount(amount, accountNumber);
    }

    @PutMapping("/operation/transfer")
    public String transferMoneyToOtherAccount(@RequestParam BigDecimal amount, @RequestParam Long accountNumberFrom,
                                              @RequestParam Long accountNumberTo) {
        return accountService.transferMoneyToOtherAccount(amount, accountNumberFrom, accountNumberTo);
    }
}
