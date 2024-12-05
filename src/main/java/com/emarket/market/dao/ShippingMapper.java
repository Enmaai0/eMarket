package com.emarket.market.dao;

import com.emarket.market.pojo.Shipping;
import io.lettuce.core.dynamic.annotation.Param;

public interface ShippingMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Shipping row);

    int insertSelective(Shipping row);

    Shipping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shipping row);

    int updateByPrimaryKey(Shipping row);

    int deleteByIdAndUid(@Param("shippingId") Integer shippingId, @Param("uid") Integer uid);
}