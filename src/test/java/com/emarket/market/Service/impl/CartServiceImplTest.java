package com.emarket.market.Service.impl;

import ch.qos.logback.classic.spi.EventArgUtil;
import com.emarket.market.EmarketApplicationTests;
import com.emarket.market.enums.ResponseEnum;
import com.emarket.market.form.CartAddForm;
import com.emarket.market.form.CartUpdateForm;
import com.emarket.market.vo.CartVo;
import com.emarket.market.vo.ResponseVo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
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
        ResponseVo<CartVo> responseVo = cartServiceimpl.add(1, cartAddForm);
        log.info("add = {}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    void listCart() {
        ResponseVo<CartVo> responseVo = cartServiceimpl.listCart(1);
        log.info("listCart = {}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    void update() {
        CartUpdateForm cartUpdateForm = new CartUpdateForm();
        cartUpdateForm.setQuantity(1);
        cartUpdateForm.setSelected(true);
        ResponseVo<CartVo> responseVo = cartServiceimpl.update(1, 27, cartUpdateForm);
        log.info("update = {}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    void delete() {
        ResponseVo<CartVo> responseVo = cartServiceimpl.delete(1, 28);
        log.info("delete = {}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    void selectAll() {
        ResponseVo<CartVo> responseVo = cartServiceimpl.selectAll(1);
        log.info("selectAll = {}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    void unSelectAll() {
        ResponseVo<CartVo> responseVo = cartServiceimpl.unSelectAll(1);
        log.info("unSelectAll = {}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    void sum() {
        ResponseVo<Integer> responseVo = cartServiceimpl.sum(1);
        log.info("sum = {}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}