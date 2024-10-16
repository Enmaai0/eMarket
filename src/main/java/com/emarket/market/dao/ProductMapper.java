package com.emarket.market.dao;

import com.emarket.market.pojo.Product;
import com.emarket.market.pojo.ProductWithBLOBs;

public interface ProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emarket_product
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emarket_product
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    int insert(ProductWithBLOBs row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emarket_product
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    int insertSelective(ProductWithBLOBs row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emarket_product
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    ProductWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emarket_product
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    int updateByPrimaryKeySelective(ProductWithBLOBs row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emarket_product
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    int updateByPrimaryKeyWithBLOBs(ProductWithBLOBs row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emarket_product
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    int updateByPrimaryKey(Product row);
}