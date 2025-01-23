package com.emarket.market.dao;

import com.emarket.market.pojo.OrderItem;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Set;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItem row);

    int insertSelective(OrderItem row);

    OrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItem row);

    int updateByPrimaryKey(OrderItem row);

    int batchInsert(List<OrderItem> orderItemList);

    List<OrderItem> selectByOrderNoSet(@Param("orderNoSet") Set orderNoSet);
}