package com.emarket.market.Controller;

import com.emarket.market.Service.impl.CartServiceImpl;
import com.emarket.market.form.CartAddForm;
import com.emarket.market.vo.CartVo;
import com.emarket.market.vo.ResponseVo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
    @Autowired
    private CartServiceImpl cartServiceimpl;
    @PostMapping("/carts")
    public ResponseVo<CartVo> add(@Valid @RequestBody CartAddForm cartAddForm) {
        return cartServiceimpl.add(1 ,cartAddForm);
    }
}
