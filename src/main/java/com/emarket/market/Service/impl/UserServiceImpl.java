package com.emarket.market.Service.impl;

import com.emarket.market.Service.UserService;
import com.emarket.market.dao.UserMapper;
import com.emarket.market.enums.ResponseEnum;
import com.emarket.market.enums.RoleEnum;
import com.emarket.market.pojo.User;
import com.emarket.market.vo.ResponseVo;
import jakarta.validation.Valid;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseVo register(@Valid User user) {
        int countByUsername = userMapper.countByUsername(user.getUsername());
        if(countByUsername > 0){
            return ResponseVo.error(ResponseEnum.USERNAME_EXIST);
        }

        int countByEmail = userMapper.countByEmail(user.getEmail());
        if(countByEmail > 0){
            return ResponseVo.error(ResponseEnum.EMAIL_EXIST);
        }

        user.setRole(RoleEnum.Customer.getCode());

        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)));

        int count = userMapper.insert(user);
        if(count != 1){
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        return ResponseVo.sucess();
    }

}