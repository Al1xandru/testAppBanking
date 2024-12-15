package org.web.bankingapp.service;

import org.web.bankingapp.entity.Account;

import java.util.List;

public interface AccountService {

    Account create(Account account, Long userId);
    void delete(Long id);
    List<Account> getCurrentAccounts();
    List<Account> getAllAccounts();
    List<Account> getByUserName(String username);
}
