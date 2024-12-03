package com.emarket.market.dao;

import com.emarket.market.pojo.Shipping;

public interface ShippingMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Shipping row);

    int insertSelective(Shipping row);

    Shipping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shipping row);

    int updateByPrimaryKey(Shipping row);
}