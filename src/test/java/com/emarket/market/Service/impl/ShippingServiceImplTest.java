package com.emarket.market.Service.impl;

import com.emarket.market.EmarketApplicationTests;
import com.emarket.market.Service.ShippingService;
import com.emarket.market.enums.ResponseEnum;
import com.emarket.market.form.ShippingForm;
import com.emarket.market.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@Transactional
class ShippingServiceImplTest extends EmarketApplicationTests {

    @Autowired
    ShippingServiceImpl shippingServiceimpl;
    private final Integer uid = 1;
    private Integer shippingId;
    ShippingForm form;

    @BeforeEach
    void before() {
        this.form = new ShippingForm();
        form.setReceiverAddress("test");
        form.setReceiverCity("test");
        form.setReceiverDistrict("test");
        form.setReceiverMobile("12345");
        form.setReceiverName("test");
        form.setReceiverPhone("123");
        form.setReceiverProvince("test");
        form.setReceiverZip("test");
        add();
    }

    @Test
    void add() {
        ResponseVo<Map<String, Integer>> responseVo = shippingServiceimpl.add(uid, form);
        this.shippingId = responseVo.getData().get("shippingId");
        log.info("add = {}", new Gson().toJson(responseVo));
        assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @AfterEach
    void delete() {
        ResponseVo responseVo = shippingServiceimpl.delete(uid, shippingId);
        log.info("delete = {}", new Gson().toJson(responseVo));
        assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    void update() {
        ShippingForm shippingForm = new ShippingForm();
        shippingForm.setReceiverAddress("notchanged");
        shippingForm.setReceiverCity("changed");
        shippingForm.setReceiverDistrict("changed");
        shippingForm.setReceiverMobile("54321");
        shippingForm.setReceiverName("changed");
        shippingForm.setReceiverPhone("123");
        shippingForm.setReceiverProvince("test");
        shippingForm.setReceiverZip("test");
        ResponseVo responseVo = shippingServiceimpl.update(uid, shippingId, shippingForm);
        log.info("update = {}", new Gson().toJson(responseVo));
        assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    void list() {
        ResponseVo<PageInfo> responseVo = shippingServiceimpl.list(1, 1, 10);
        log.info("list = {}", new Gson().toJson(responseVo));
        assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}