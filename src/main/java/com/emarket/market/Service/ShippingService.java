package com.emarket.market.Service;

import com.emarket.market.form.ShippingForm;
import com.emarket.market.vo.ResponseVo;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface ShippingService {
    ResponseVo<Map<String, Integer>> add(Integer uid, ShippingForm form);

    ResponseVo delete(Integer uid, Integer shippingId);

    ResponseVo update(Integer uid, Integer shippingId, ShippingForm shippingForm);

    ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize);
}
