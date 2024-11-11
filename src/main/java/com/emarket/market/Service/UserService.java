package com.emarket.market.Service;

import com.emarket.market.pojo.User;
import com.emarket.market.vo.ResponseVo;

public interface UserService {
    ResponseVo<User> register(User user);

    ResponseVo<User> login(String username, String password);
}
