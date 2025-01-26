package com.emarket.market.Service.impl;

import com.emarket.market.EmarketApplicationTests;
import com.emarket.market.enums.ResponseEnum;
import com.emarket.market.form.CartAddForm;
import com.emarket.market.vo.CartVo;
import com.emarket.market.vo.OrderVo;
import com.emarket.market.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@Transactional
class OrderServiceImplTest extends EmarketApplicationTests {
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private CartServiceImpl cartServiceiml;
    private Integer uid = 1;
    private Integer shippingId = 4;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @BeforeEach
    void addCart() {
        CartAddForm cartAddForm = new CartAddForm();
        cartAddForm.setProductId(28);
        cartAddForm.setSelected(true);
        cartServiceiml.add(1, cartAddForm);
    }

    @Test
    void create() {
        ResponseVo<OrderVo> responseVo = createForTest();
        log.info("responseVo={}", gson.toJson(responseVo));
        assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    private ResponseVo<OrderVo> createForTest() {
        return orderService.create(uid, shippingId);
    }

    @Test
    void list() {
        ResponseVo<PageInfo> responseVo = orderService.list(uid, 1, 10);
        log.info("responseVo={}", gson.toJson(responseVo));
        assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    void detail() {
        ResponseVo<OrderVo> vo = createForTest();
        ResponseVo<OrderVo> responseVo = orderService.detail(uid, vo.getData().getOrderNo());
        log.info("responseVo={}", gson.toJson(responseVo));
        assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}