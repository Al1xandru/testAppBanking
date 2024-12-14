package org.web.bankingapp.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import org.web.bankingapp.entity.Account;

import java.util.ArrayList;
import java.util.List;

public class UserResponseDto {

    private Long id;
    private String username;
    private String email;
    private List<Account> accounts;

    public UserResponseDto(Long id, String username, String email, List<Account> accounts) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.accounts = accounts;
    }

    public UserResponseDto(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
