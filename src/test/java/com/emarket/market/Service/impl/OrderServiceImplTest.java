package com.emarket.market.Service.impl;

import com.emarket.market.EmarketApplicationTests;
import com.emarket.market.enums.ResponseEnum;
import com.emarket.market.vo.OrderVo;
import com.emarket.market.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class OrderServiceImplTest extends EmarketApplicationTests {
    @Autowired
    private OrderServiceImpl orderService;
    private Integer uid = 1;
    private Integer shippingId = 4;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Test
    void create() {
        ResponseVo<OrderVo> responseVo = orderService.create(uid, shippingId);
        log.info("responseVo={}", gson.toJson(responseVo));
        assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    void list() {
        ResponseVo<PageInfo> responseVo = orderService.list(uid, 1, 10);
        log.info("responseVo={}", gson.toJson(responseVo));
        assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}