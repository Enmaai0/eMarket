package com.emarket.market.Service;

import com.emarket.market.form.CartAddForm;
import com.emarket.market.form.CartUpdateForm;
import com.emarket.market.vo.CartVo;
import com.emarket.market.vo.ResponseVo;

public interface CarService {
    ResponseVo<CartVo> add(Integer uid, CartAddForm cartAddForm);

    ResponseVo<CartVo> listCart(Integer uid);

    ResponseVo<CartVo> update(Integer uid, Integer productId, CartUpdateForm cartUpdateForm);

    ResponseVo<CartVo> delete(Integer uid, Integer productId);
}
