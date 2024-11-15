package com.emarket.market.Controller;

import com.emarket.market.Service.ProductService;
import com.emarket.market.vo.ProductVo;
import com.emarket.market.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseVo<PageInfo> listProducts(Integer categoryId,
                                             @RequestParam(defaultValue = "1") Integer pageNum,
                                             @RequestParam(defaultValue = "10") Integer pageSize) {
        return productService.productList(categoryId, pageNum, pageSize);
    }
}
