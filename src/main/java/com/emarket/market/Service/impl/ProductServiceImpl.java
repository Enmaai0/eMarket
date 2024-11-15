package com.emarket.market.Service.impl;

import com.emarket.market.Service.CategoryService;
import com.emarket.market.Service.ProductService;
import com.emarket.market.dao.ProductMapper;
import com.emarket.market.pojo.Product;
import com.emarket.market.vo.ProductVo;
import com.emarket.market.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public ResponseVo<List<ProductVo>> productList(Integer categoryId, Integer pageNum, Integer pageSize) {
        Set<Integer> categoryIdSet = new HashSet<>();
        categoryService.findSubCategoryId(categoryId, categoryIdSet);
        categoryIdSet.add(categoryId);
        List<Product> products = productMapper.selectByCategoryIdSet(categoryIdSet);

        List<ProductVo> productVoList = new ArrayList<>();
        for(Product product : products) {
            ProductVo productVo = new ProductVo();
            BeanUtils.copyProperties(product, productVo);
            productVoList.add(productVo);
        }
        return ResponseVo.success(productVoList);
    }
}
