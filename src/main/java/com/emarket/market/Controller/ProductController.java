package com.emarket.market.Controller;

import com.emarket.market.Service.ProductService;
import com.emarket.market.vo.ProductVo;
import com.emarket.market.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseVo<List<ProductVo>> listProducts() {
        return productService.productList(null, 1, 10);
    }
}
