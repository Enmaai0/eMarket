package com.emarket.market.Service.impl;

import com.emarket.market.EmarketApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest extends EmarketApplicationTests {
    @Autowired
    private ProductServiceImpl productServiceImpl;
    @Test
    void productList() {
        productServiceImpl.productList(null, 1, 10);
    }
}