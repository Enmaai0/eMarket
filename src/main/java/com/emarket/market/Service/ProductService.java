package com.emarket.market.Service;

import com.emarket.market.vo.ProductVo;
import com.emarket.market.vo.ResponseVo;

import java.util.List;

public interface ProductService {
    ResponseVo<List<ProductVo>> productList(Integer categoryId, Integer pageNum, Integer pageSize);
}
