package com.emarket.market.Service.impl;

import com.emarket.market.EmarketApplicationTests;
import com.emarket.market.enums.ResponseEnum;
import com.emarket.market.vo.CategoryVo;
import com.emarket.market.vo.ResponseVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
class CategoryServiceImplTest extends EmarketApplicationTests {
    @Autowired
    private CategoryServiceImpl categoryService;
    @Test
    void list() {
        ResponseVo<List<CategoryVo>> response = categoryService.list();
        assertEquals(ResponseEnum.SUCCESS.getCode(), response.getStatus());
    }
}