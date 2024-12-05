package com.emarket.market.Service.impl;

import com.emarket.market.EmarketApplicationTests;
import com.emarket.market.Service.ShippingService;
import com.emarket.market.enums.ResponseEnum;
import com.emarket.market.form.ShippingForm;
import com.emarket.market.vo.ResponseVo;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class ShippingServiceImplTest extends EmarketApplicationTests {

    @Autowired
    ShippingServiceImpl shippingServiceimpl;

    @Test
    void add() {
        ShippingForm shippingForm = new ShippingForm();
        shippingForm.setReceiverAddress("test");
        shippingForm.setReceiverCity("test");
        shippingForm.setReceiverDistrict("test");
        shippingForm.setReceiverMobile("12345");
        shippingForm.setReceiverName("test");
        shippingForm.setReceiverPhone("123");
        shippingForm.setReceiverProvince("test");
        shippingForm.setReceiverZip("test");
        ResponseVo<Map<String, Integer>> responseVo = shippingServiceimpl.add(1, shippingForm);
        log.info("add = {}", new Gson().toJson(responseVo));
        assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    void delete() {
        ResponseVo responseVo = shippingServiceimpl.delete(1, 7);
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
        ResponseVo responseVo = shippingServiceimpl.update(1, 6, shippingForm);
        log.info("update = {}", new Gson().toJson(responseVo));
        assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}