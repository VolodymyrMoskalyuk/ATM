package com.test.atm.controller;

import com.test.atm.model.Account;
import com.test.atm.service.AccountService;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole( 'ROLE_CLIENT') and principal.getUsername() == #accountNumber")
    public String addMoneyToAccount(@RequestParam BigDecimal amount, @RequestParam Long accountNumber) {
        return accountService.addMoneyToAccount(amount, accountNumber);
    }

    @PostMapping("/operation/get-money")
    @PreAuthorize("hasRole( 'ROLE_CLIENT') and principal.getUsername() == #accountNumber")
    public String getMoneyFromAccount(@RequestParam BigDecimal amount, @RequestParam Long accountNumber) {
        return accountService.getMoneyFromAccount(amount, accountNumber);
    }

    @PutMapping("/operation/transfer")
    @PreAuthorize("hasRole( 'ROLE_CLIENT') and principal.getUsername() == #accountNumberFrom")
    public String transferMoneyToOtherAccount(@RequestParam BigDecimal amount, @RequestParam Long accountNumberFrom,
                                              @RequestParam Long accountNumberTo) {
        return accountService.transferMoneyToOtherAccount(amount, accountNumberFrom, accountNumberTo);
    }
}
