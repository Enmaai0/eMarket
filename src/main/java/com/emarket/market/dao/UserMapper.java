package com.emarket.market.dao;

import com.emarket.market.pojo.User;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emarket_user
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emarket_user
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    int insert(User row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emarket_user
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    int insertSelective(User row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emarket_user
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    User selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emarket_user
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    int updateByPrimaryKeySelective(User row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emarket_user
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    int updateByPrimaryKey(User row);
}