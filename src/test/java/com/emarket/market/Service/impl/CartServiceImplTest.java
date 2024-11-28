package com.emarket.market.Service.impl;

import ch.qos.logback.classic.spi.EventArgUtil;
import com.emarket.market.EmarketApplicationTests;
import com.emarket.market.form.CartAddForm;
import com.emarket.market.vo.CartVo;
import com.emarket.market.vo.ResponseVo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
class CartServiceImplTest extends EmarketApplicationTests {
    @Autowired
    private CartServiceImpl cartServiceimpl;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Test
    void add() {
        CartAddForm cartAddForm = new CartAddForm();
        cartAddForm.setProductId(28);
        cartAddForm.setSelected(true);
        cartServiceimpl.add(1, cartAddForm);
    }

    @Test
    void listCart() {
        ResponseVo<CartVo> cartVoResponseVo = cartServiceimpl.listCart(1);
        log.info("listCart = {}", gson.toJson(cartVoResponseVo));
    }
}