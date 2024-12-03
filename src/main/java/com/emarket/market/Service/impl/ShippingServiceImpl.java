package com.emarket.market.Service.impl;

import com.emarket.market.Service.ShippingService;
import com.emarket.market.dao.ShippingMapper;
import com.emarket.market.enums.ResponseEnum;
import com.emarket.market.form.ShippingForm;
import com.emarket.market.pojo.Shipping;
import com.emarket.market.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ShippingServiceImpl implements ShippingService {
    @Autowired
    ShippingMapper shippingMapper;
    @Override
    public ResponseVo<Map<String, Integer>> add(Integer uid, ShippingForm form) {
        Shipping shipping = new Shipping();
        BeanUtils.copyProperties(form, shipping);
        shipping.setUserId(uid);
        int count = shippingMapper.insertSelective(shipping);
        if(count == 0) {
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        HashMap<String, Integer> map = new HashMap<>();
        map.put("shippingId", shipping.getId());
        return ResponseVo.success(map);
    }

    @Override
    public ResponseVo delete(Integer uid, Integer shippingId) {
        return null;
    }

    @Override
    public ResponseVo update(Integer uid, Integer shippingId, ShippingForm shippingForm) {
        return null;
    }

    @Override
    public ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize) {
        return null;
    }
}
