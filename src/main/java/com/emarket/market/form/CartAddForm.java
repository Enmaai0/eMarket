package com.emarket.market.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CartAddForm {
    @NotNull(message = "productId cannot be empty")
    private Integer productId;

    private Boolean selected = true;
}
