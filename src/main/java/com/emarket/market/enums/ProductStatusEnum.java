package com.emarket.market.enums;

import lombok.Data;
import lombok.Getter;

@Getter
public enum ProductStatusEnum {
    ON_SALE(1),
    OFF_SALE(2),
    DELETE(3),
    ;

    final Integer code;

    ProductStatusEnum(Integer code) {
        this.code = code;
    }
}
