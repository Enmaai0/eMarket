package com.emarket.market.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLoginForm {
    @NotBlank(message = "Username cannot be empty")
    private String username;

    @NotBlank(message = "Password cannot be empty")
    private String password;

    public UserLoginForm(String username, String password, String email) {
        this.username = username;
        this.password = password;
    }
}
