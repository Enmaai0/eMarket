package com.emarket.market.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    CANCELED(0, "Canceled"),
    NO_PAY(10, "No pay"),
    PAID(20, "Paid"),
    SHIPPED(40, "Shipped"),
    TRADE_SUCCESS(50, "Trade success"),
    TRADE_CLOSE(60, "Trade close"),
    ;

    Integer code;
    String desc;

    OrderStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
