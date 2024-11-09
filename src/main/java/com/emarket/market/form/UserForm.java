package com.emarket.market.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserForm {
    @NotBlank(message = "Username cannot be empty")
    private String username;

    @NotBlank(message = "Password cannot be empty")
    private String password;

    @NotBlank(message = "Email cannot be empty")
    private String email;

    public UserForm(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
