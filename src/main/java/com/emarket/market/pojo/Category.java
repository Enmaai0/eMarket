package com.emarket.market.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Category {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emarket_category.id
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emarket_category.parent_id
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    private Integer parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emarket_category.name
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emarket_category.status
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    private Boolean status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emarket_category.sort_order
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    private Integer sortOrder;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emarket_category.create_time
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emarket_category.update_time
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    private Date updateTime;

    private List<Category> subCategories;
}