package com.emarket.market.Controller;

import com.emarket.market.Service.UserService;
import com.emarket.market.constant.EmarketConst;
import com.emarket.market.enums.ResponseEnum;
import com.emarket.market.form.UserLoginForm;
import com.emarket.market.form.UserRegisterForm;
import com.emarket.market.pojo.User;
import com.emarket.market.vo.ResponseVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/register")
    public ResponseVo<User> register(@Valid @RequestBody UserRegisterForm userRegisterForm) {
        User user = new User();
        BeanUtils.copyProperties(userRegisterForm, user);
        return userService.register(user);
    }

    @PostMapping("/user/login")
    public ResponseVo<User> login(@Valid @RequestBody UserLoginForm userLoginForm, HttpServletRequest request) {
        ResponseVo<User> responseVo = userService.login(userLoginForm.getUsername(), userLoginForm.getPassword());
        HttpSession session = request.getSession();
        session.setAttribute(EmarketConst.CURRENT_USER, responseVo.getData());
        return responseVo;
    }

    @GetMapping("/user")
    public ResponseVo<User> userInfo(HttpSession session) {
        log.info("/user sessionId={}", session.getId());
        User user = (User) session.getAttribute(EmarketConst.CURRENT_USER);
        return ResponseVo.success(user);
    }

    @PostMapping("/user/logout")
    public ResponseVo<User> logout(HttpSession session) {
        log.info("/user/logout sessionId={}", session.getId());
        session.removeAttribute(EmarketConst.CURRENT_USER);
        return ResponseVo.success();
    }
}
