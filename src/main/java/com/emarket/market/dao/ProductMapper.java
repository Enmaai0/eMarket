package com.emarket.market.dao;

import com.emarket.market.pojo.Product;

import java.util.List;
import java.util.Set;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product row);

    int insertSelective(Product row);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product row);

    int updateByPrimaryKey(Product row);

    List<Product> selectByCategoryIdSet(Set<Integer> categoryIdSet);

    List<Product> selectByProductIdSet(Set<Integer> productIdSet);
}