package com.emarket.market.Controller;

import com.emarket.market.dao.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    @Autowired
    private CategoryMapper categoryMapper;
    @GetMapping("/category")
    public String category() {
        return categoryMapper.selectByPrimaryKey(100001).getName();
    }
}
