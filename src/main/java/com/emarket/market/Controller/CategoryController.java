package com.emarket.market.Controller;

import com.emarket.market.Service.CategoryService;
import com.emarket.market.dao.CategoryMapper;
import com.emarket.market.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/categories")
    public ResponseVo list() {
        return categoryService.list();
    }
}
