package org.web.bankingapp.dto;
import org.web.bankingapp.entity.User;
import org.web.bankingapp.enums.CurrencyType;

public class AccountDto {

    private String accountNumber;
    private Double balance;
    private Long userId;

    public AccountDto(String accountNumber, Double balance, Long userId) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.userId = userId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
