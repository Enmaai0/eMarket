package com.emarket.market.Service;

import com.emarket.market.pojo.Category;
import com.emarket.market.vo.CategoryVo;
import com.emarket.market.vo.ResponseVo;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    ResponseVo<List<CategoryVo>> list();

    void findSubCategoryId(Integer id, Set<Integer> resultSet);
}
