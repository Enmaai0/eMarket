package com.emarket.market.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emarket_product.id
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emarket_product.category_id
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    private Integer categoryId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emarket_product.name
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emarket_product.subtitle
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    private String subtitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emarket_product.main_image
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    private String mainImage;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emarket_product.price
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    private BigDecimal price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emarket_product.stock
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    private Integer stock;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emarket_product.status
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emarket_product.create_time
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emarket_product.update_time
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emarket_product.id
     *
     * @return the value of emarket_product.id
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emarket_product.id
     *
     * @param id the value for emarket_product.id
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emarket_product.category_id
     *
     * @return the value of emarket_product.category_id
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emarket_product.category_id
     *
     * @param categoryId the value for emarket_product.category_id
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emarket_product.name
     *
     * @return the value of emarket_product.name
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emarket_product.name
     *
     * @param name the value for emarket_product.name
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emarket_product.subtitle
     *
     * @return the value of emarket_product.subtitle
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emarket_product.subtitle
     *
     * @param subtitle the value for emarket_product.subtitle
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle == null ? null : subtitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emarket_product.main_image
     *
     * @return the value of emarket_product.main_image
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    public String getMainImage() {
        return mainImage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emarket_product.main_image
     *
     * @param mainImage the value for emarket_product.main_image
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    public void setMainImage(String mainImage) {
        this.mainImage = mainImage == null ? null : mainImage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emarket_product.price
     *
     * @return the value of emarket_product.price
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emarket_product.price
     *
     * @param price the value for emarket_product.price
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emarket_product.stock
     *
     * @return the value of emarket_product.stock
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emarket_product.stock
     *
     * @param stock the value for emarket_product.stock
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emarket_product.status
     *
     * @return the value of emarket_product.status
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emarket_product.status
     *
     * @param status the value for emarket_product.status
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emarket_product.create_time
     *
     * @return the value of emarket_product.create_time
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emarket_product.create_time
     *
     * @param createTime the value for emarket_product.create_time
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emarket_product.update_time
     *
     * @return the value of emarket_product.update_time
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emarket_product.update_time
     *
     * @param updateTime the value for emarket_product.update_time
     *
     * @mbg.generated Sat Sep 28 17:31:14 AEST 2024
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}