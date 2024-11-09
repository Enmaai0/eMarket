package com.emarket.market.Service;

import com.emarket.market.form.UserForm;
import com.emarket.market.pojo.User;
import com.emarket.market.vo.ResponseVo;
import jakarta.validation.Valid;

public interface UserService {
    ResponseVo register(@Valid User user);
}
