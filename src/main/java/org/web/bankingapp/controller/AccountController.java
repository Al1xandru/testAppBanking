package org.web.bankingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.web.bankingapp.dto.AccountDto;
import org.web.bankingapp.entity.Account;
import org.web.bankingapp.service.AccountService;
import org.web.bankingapp.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public AccountDto create(@RequestBody AccountDto request) {
        Account account = new Account();
        account.setAccountNumber(request.getAccountNumber());
        account.setBalance(request.getBalance());
        Account tempAcc = accountService.create(account, request.getUserId());
        return new AccountDto(tempAcc.getAccountNumber(), tempAcc.getBalance(), tempAcc.getId());
    }

    @GetMapping("/current")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    private List<AccountDto> getCurrentUserAccounts() {
        return accountService.getCurrentAccounts().stream()
                .map(account -> new AccountDto(account.getAccountNumber(), account.getBalance(), account.getId()))
                .collect(Collectors.toList());
    }


    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    private List<AccountDto> getAccounts() {
        return accountService.getAllAccounts().stream()
                .map(account -> new AccountDto(account.getAccountNumber(), account.getBalance(), account.getId()))
                .collect(Collectors.toList());
    }

}
