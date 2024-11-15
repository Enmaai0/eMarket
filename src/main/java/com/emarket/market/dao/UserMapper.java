package com.emarket.market.dao;

import com.emarket.market.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User row);

    int insertSelective(User row);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User row);

    int updateByPrimaryKey(User row);

    User selectByUsername(String username);

    int countByUsername(String username);

    int countByEmail(String email);
}