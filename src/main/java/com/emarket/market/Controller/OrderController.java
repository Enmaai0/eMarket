package com.emarket.market.Controller;

import com.emarket.market.Service.OrderService;
import com.emarket.market.constant.EmarketConst;
import com.emarket.market.form.OrderCreateForm;
import com.emarket.market.pojo.User;
import com.emarket.market.vo.OrderVo;
import com.emarket.market.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public ResponseVo<OrderVo> create(@Valid @RequestBody OrderCreateForm form,
                                      HttpSession session) {
        User user = (User) session.getAttribute(EmarketConst.CURRENT_USER);
        return orderService.create(user.getId(),
                form.getShippingId());
    }

    @GetMapping("/orders")
    public ResponseVo<PageInfo> list(HttpSession session,
                                     @RequestParam Integer pageNum,
                                     @RequestParam Integer pageSize) {
        User user = (User) session.getAttribute(EmarketConst.CURRENT_USER);
        return orderService.list(user.getId(), pageNum, pageSize);
    }

    @GetMapping("/orders/{orderNo}")
    public ResponseVo<OrderVo> detail(@PathVariable Long orderNo, HttpSession session) {
        User user = (User) session.getAttribute(EmarketConst.CURRENT_USER);
        return orderService.detail(user.getId(), orderNo);
    }

    @PutMapping("/orders/{orderNo}")
    public ResponseVo cancel(@PathVariable Long orderNo, HttpSession session) {
        User user = (User) session.getAttribute(EmarketConst.CURRENT_USER);
        return orderService.cancel(user.getId(), orderNo);
    }

}
