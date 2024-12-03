package com.emarket.market.Controller;

import com.emarket.market.Service.impl.CartServiceImpl;
import com.emarket.market.constant.EmarketConst;
import com.emarket.market.form.CartAddForm;
import com.emarket.market.form.CartUpdateForm;
import com.emarket.market.pojo.User;
import com.emarket.market.vo.CartVo;
import com.emarket.market.vo.ResponseVo;
import io.netty.util.Constant;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {
    @Autowired
    private CartServiceImpl cartServiceimpl;
    @PostMapping("/carts")
    public ResponseVo<CartVo> add(@Valid @RequestBody CartAddForm cartAddForm, HttpSession session) {
        User user = (User) session.getAttribute(EmarketConst.CURRENT_USER);
        return cartServiceimpl.add(user.getId() ,cartAddForm);
    }

    @PutMapping("/carts/{productId}")
    public ResponseVo<CartVo> update(@Valid @RequestBody CartUpdateForm cartUpdateForm, HttpSession session, @PathVariable Integer productId) {
        User user = (User) session.getAttribute(EmarketConst.CURRENT_USER);
        return cartServiceimpl.update(user.getId(), productId, cartUpdateForm);
    }

    @GetMapping("/carts")
    public ResponseVo<CartVo> list(HttpSession session) {
        User user = (User) session.getAttribute(EmarketConst.CURRENT_USER);
        return cartServiceimpl.listCart(user.getId());
    }

    @DeleteMapping("/carts/{productId}")
    public ResponseVo<CartVo> delete(HttpSession session, @PathVariable Integer productId) {
        User user = (User) session.getAttribute(EmarketConst.CURRENT_USER);
        return cartServiceimpl.delete(user.getId(), productId);
    }

    @PutMapping("/carts/selectAll")
    public ResponseVo<CartVo> selectAll(HttpSession session) {
        User user = (User) session.getAttribute(EmarketConst.CURRENT_USER);
        return cartServiceimpl.selectAll(user.getId());
    }

    @PutMapping("/carts/unSelectAll")
    public ResponseVo<CartVo> unSelectAll(HttpSession session) {
        User user = (User) session.getAttribute(EmarketConst.CURRENT_USER);
        return cartServiceimpl.unSelectAll(user.getId());
    }

    @GetMapping("/carts/products/sum")
    public ResponseVo<Integer> sum(HttpSession session) {
        User user = (User) session.getAttribute(EmarketConst.CURRENT_USER);
        return cartServiceimpl.sum(user.getId());
    }
}
