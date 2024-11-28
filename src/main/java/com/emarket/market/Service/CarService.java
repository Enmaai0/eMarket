package com.emarket.market.Service;

import com.emarket.market.form.CartAddForm;
import com.emarket.market.vo.CartVo;
import com.emarket.market.vo.ResponseVo;

public interface CarService {
    ResponseVo<CartVo> add(Integer uid, CartAddForm cartAddForm);

    ResponseVo<CartVo> listCart(Integer uid);
}
