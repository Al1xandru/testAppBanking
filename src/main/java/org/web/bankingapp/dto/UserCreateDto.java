package org.web.bankingapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.web.bankingapp.validation.ValidPassword;

public class UserCreateDto {

    @NotBlank(message = "Username is required")
    @Size(min = 5, max = 10, message = "Username must be between 5 and 10 characters")
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters")
    @ValidPassword
    private String password;

    public UserCreateDto() {
    }

    public @NotBlank(message = "Username is required") @Size(min = 5, max = 10, message = "Username must be between 5 and 10 characters") String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = "Username is required") @Size(min = 5, max = 10, message = "Username must be between 5 and 10 characters") String username) {
        this.username = username;
    }

    public @NotBlank(message = "Email is required") @Email(message = "Email must be valid") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is required") @Email(message = "Email must be valid") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Password is required") @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password is required") @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters") String password) {
        this.password = password;
    }
}
