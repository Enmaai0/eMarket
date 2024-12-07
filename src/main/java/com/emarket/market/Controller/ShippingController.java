package com.emarket.market.Controller;

import com.emarket.market.Service.impl.ShippingServiceImpl;
import com.emarket.market.constant.EmarketConst;
import com.emarket.market.form.ShippingForm;
import com.emarket.market.pojo.User;
import com.emarket.market.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ShippingController {
    @Autowired
    private ShippingServiceImpl shippingService;

    @PostMapping("/shippings")
    public ResponseVo<Map<String, Integer>> add(@Valid @RequestBody ShippingForm form, HttpSession session) {
        User user = (User) session.getAttribute(EmarketConst.CURRENT_USER);
        return shippingService.add(user.getId(), form);
    }

    @DeleteMapping("/shippings/{shippingId}")
    public ResponseVo delete(@PathVariable Integer shippingId, HttpSession session) {
        User user = (User) session.getAttribute(EmarketConst.CURRENT_USER);
        return shippingService.delete(user.getId(), shippingId);
    }

    @PutMapping("/shippings/{shippingId}")
    public ResponseVo update(@PathVariable Integer shippingId, @Valid @RequestBody ShippingForm form, HttpSession session) {
        User user = (User) session.getAttribute(EmarketConst.CURRENT_USER);
        return shippingService.update(user.getId(), shippingId, form);
    }

    @GetMapping("/shippings")
    public ResponseVo<PageInfo> get(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize, HttpSession session) {
        User user = (User) session.getAttribute(EmarketConst.CURRENT_USER);
        return shippingService.list(user.getId(), pageNum, pageSize);
    }
}
