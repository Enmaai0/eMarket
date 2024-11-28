package com.emarket.market.Service.impl;

import com.emarket.market.Service.CategoryService;
import com.emarket.market.Service.ProductService;
import com.emarket.market.dao.ProductMapper;
import com.emarket.market.enums.ResponseEnum;
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

import static com.emarket.market.enums.ProductStatusEnum.DELETE;
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
        if(categoryId != null) {
            categoryService.findSubCategoryId(categoryId, categoryIdSet);
            categoryIdSet.add(categoryId);
        }

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

    @Override
    public ResponseVo<ProductDetailVo> detail(Integer productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        if(product.getStatus().equals(OFF_SALE.getCode()) || product.getStatus().equals(DELETE.getCode())) {
            return ResponseVo.error(ResponseEnum.PRODUCT_OFF_SALE_OR_DELETE);
        }
        ProductDetailVo productDetailVo = new ProductDetailVo();
        BeanUtils.copyProperties(product, productDetailVo);
        return ResponseVo.success(productDetailVo);
    }
}
