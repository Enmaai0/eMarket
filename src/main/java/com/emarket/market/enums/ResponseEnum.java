package com.emarket.market.enums;

import lombok.Getter;

@Getter
public enum ResponseEnum {
    ERROR(-1, "Server error"),
    SUCCESS(0, "Success"),
    PASSWORD_ERROR(1, "Incorrect password"),
    USERNAME_EXIST(2, "Username already exists"),
    PARAM_ERROR(3, "Parameter error"),
    EMAIL_EXIST(4, "Email already exists"),
    NEED_LOGIN(10, "User not logged in, please log in"),
    USERNAME_OR_PASSWORD_ERROR(11, "Username or password is incorrect"),
    PRODUCT_OFF_SALE_OR_DELETE(12, "Product off sale or deleted"),
    PRODUCT_NOT_EXIST(13, "Product does not exist"),
    PRODUCT_STOCK_ERROR(14, "Product stock error"),
    CART_PRODUCT_NOT_EXIST(15, "Product not in cart"),
    DELETE_SHIPPING_FAIL(16, "Delete shipping address failed"),
    SHIPPING_NOT_EXIST(17, "Shipping address does not exist"),
    CART_SELECTED_IS_EMPTY(18, "No product selected in cart"),
    ORDER_NOT_EXIST(19, "Order does not exist"),
    ORDER_STATUS_ERROR(20, "Order status error"),
    ;

    final Integer code;
    final String desc;

    ResponseEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
