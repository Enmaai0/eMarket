package com.emarket.market.enums;

import lombok.Getter;
@Getter
public enum RoleEnum {
    Admin(0),

    Customer(1);

    final int code;
    RoleEnum(int code) {
        this.code = code;
    }

}
