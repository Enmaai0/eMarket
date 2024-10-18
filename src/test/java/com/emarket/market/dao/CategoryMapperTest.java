package com.emarket.market.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;
@Component
class CategoryMapperTest {
    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    void selectByPrimaryKey() {
        assertNotNull(categoryMapper.selectByPrimaryKey(100001));
        System.out.println(categoryMapper.selectByPrimaryKey(100001));
    }
}