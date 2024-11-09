package com.emarket.market.Controller;

import com.emarket.market.Service.UserService;
import com.emarket.market.enums.ResponseEnum;
import com.emarket.market.form.UserForm;
import com.emarket.market.pojo.User;
import com.emarket.market.vo.ResponseVo;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("register")
    public ResponseVo register(@Valid @RequestBody UserForm userForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            log.error("Registration error: {}", Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            return ResponseVo.error(ResponseEnum.PARAM_ERROR,
                    Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        User user = new User();
        BeanUtils.copyProperties(userForm, user);
        return userService.register(user);
    }
}
