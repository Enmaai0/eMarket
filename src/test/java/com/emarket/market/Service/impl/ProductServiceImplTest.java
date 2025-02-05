package com.emarket.market.Service.impl;

import com.emarket.market.EmarketApplicationTests;
import com.emarket.market.enums.ResponseEnum;
import com.emarket.market.vo.ResponseVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
class ProductServiceImplTest extends EmarketApplicationTests {
    @Autowired
    private ProductServiceImpl productServiceImpl;
    @Test
    void productList() {
        productServiceImpl.productList(null, 1, 10);
    }

    @Test
    void detail() {
        ResponseVo response = productServiceImpl.detail(27);
        assertEquals(ResponseEnum.SUCCESS.getCode(), response.getStatus());
    }
}