package com.emarket.market.Service;

import com.emarket.market.pojo.Product;
import com.emarket.market.vo.ProductDetailVo;
import com.emarket.market.vo.ProductVo;
import com.emarket.market.vo.ResponseVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProductService {
    ResponseVo<PageInfo> productList(Integer categoryId, Integer pageNum, Integer pageSize);

    ResponseVo<ProductDetailVo> detail(Integer productId);
}
