package com.emarket.market.form;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderCreateForm {
    @NotNull
    private Integer shippingId;
}
