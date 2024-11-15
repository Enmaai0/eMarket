package com.emarket.market.Service.impl;

import com.emarket.market.Service.CategoryService;
import com.emarket.market.Service.ProductService;
import com.emarket.market.dao.ProductMapper;
import com.emarket.market.pojo.Product;
import com.emarket.market.vo.ProductDetailVo;
import com.emarket.market.vo.ProductVo;
import com.emarket.market.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.emarket.market.enums.ProductStatusEnum.OFF_SALE;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public ResponseVo<PageInfo> productList(Integer categoryId, Integer pageNum, Integer pageSize) {
        Set<Integer> categoryIdSet = new HashSet<>();
        categoryService.findSubCategoryId(categoryId, categoryIdSet);
        categoryIdSet.add(categoryId);
        PageHelper.startPage(pageNum, pageSize);
        List<Product> products = productMapper.selectByCategoryIdSet(categoryIdSet);

        List<ProductVo> productVoList = new ArrayList<>();
        for(Product product : products) {
            ProductVo productVo = new ProductVo();
            BeanUtils.copyProperties(product, productVo);
            productVoList.add(productVo);
        }
        PageInfo<ProductVo> pageInfo = new PageInfo<>(productVoList);
        return ResponseVo.success(pageInfo);
    }
}
