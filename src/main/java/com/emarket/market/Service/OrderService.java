package com.emarket.market.Service;


import com.emarket.market.vo.OrderVo;
import com.emarket.market.vo.ResponseVo;
import com.github.pagehelper.PageInfo;

public interface OrderService {

    ResponseVo<OrderVo> create(Integer uid, Integer shippingId);

    ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize);

    ResponseVo<OrderVo> detail(Integer uid, Long orderNo);

    ResponseVo cancel(Integer uid, Long orderNo);
}
