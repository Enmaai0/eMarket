package com.emarket.market.Service;


import com.emarket.market.vo.OrderVo;
import com.emarket.market.vo.ResponseVo;

public interface OrderService {

    ResponseVo<OrderVo> create(Integer uid, Integer shippingId);
}
