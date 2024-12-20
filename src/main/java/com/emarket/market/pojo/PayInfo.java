package com.emarket.market.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class PayInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emarket_pay_info.id
     *
     * @mbg.generated Fri Nov 15 12:17:43 AEDT 2024
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emarket_pay_info.user_id
     *
     * @mbg.generated Fri Nov 15 12:17:43 AEDT 2024
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emarket_pay_info.order_no
     *
     * @mbg.generated Fri Nov 15 12:17:43 AEDT 2024
     */
    private Long orderNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emarket_pay_info.pay_platform
     *
     * @mbg.generated Fri Nov 15 12:17:43 AEDT 2024
     */
    private Integer payPlatform;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emarket_pay_info.platform_number
     *
     * @mbg.generated Fri Nov 15 12:17:43 AEDT 2024
     */
    private String platformNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emarket_pay_info.platform_status
     *
     * @mbg.generated Fri Nov 15 12:17:43 AEDT 2024
     */
    private String platformStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emarket_pay_info.pay_amount
     *
     * @mbg.generated Fri Nov 15 12:17:43 AEDT 2024
     */
    private BigDecimal payAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emarket_pay_info.create_time
     *
     * @mbg.generated Fri Nov 15 12:17:43 AEDT 2024
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emarket_pay_info.update_time
     *
     * @mbg.generated Fri Nov 15 12:17:43 AEDT 2024
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emarket_pay_info.id
     *
     * @return the value of emarket_pay_info.id
     *
     * @mbg.generated Fri Nov 15 12:17:43 AEDT 2024
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emarket_pay_info.id
     *
     * @param id the value for emarket_pay_info.id
     *
     * @mbg.generated Fri Nov 15 12:17:43 AEDT 2024
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emarket_pay_info.user_id
     *
     * @return the value of emarket_pay_info.user_id
     *
     * @mbg.generated Fri Nov 15 12:17:43 AEDT 2024
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emarket_pay_info.user_id
     *
     * @param userId the value for emarket_pay_info.user_id
     *
     * @mbg.generated Fri Nov 15 12:17:43 AEDT 2024
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emarket_pay_info.order_no
     *
     * @return the value of emarket_pay_info.order_no
     *
     * @mbg.generated Fri Nov 15 12:17:43 AEDT 2024
     */
    public Long getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emarket_pay_info.order_no
     *
     * @param orderNo the value for emarket_pay_info.order_no
     *
     * @mbg.generated Fri Nov 15 12:17:43 AEDT 2024
     */
    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emarket_pay_info.pay_platform
     *
     * @return the value of emarket_pay_info.pay_platform
     *
     * @mbg.generated Fri Nov 15 12:17:43 AEDT 2024
     */
    public Integer getPayPlatform() {
        return payPlatform;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emarket_pay_info.pay_platform
     *
     * @param payPlatform the value for emarket_pay_info.pay_platform
     *
     * @mbg.generated Fri Nov 15 12:17:43 AEDT 2024
     */
    public void setPayPlatform(Integer payPlatform) {
        this.payPlatform = payPlatform;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emarket_pay_info.platform_number
     *
     * @return the value of emarket_pay_info.platform_number
     *
     * @mbg.generated Fri Nov 15 12:17:43 AEDT 2024
     */
    public String getPlatformNumber() {
        return platformNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emarket_pay_info.platform_number
     *
     * @param platformNumber the value for emarket_pay_info.platform_number
     *
     * @mbg.generated Fri Nov 15 12:17:43 AEDT 2024
     */
    public void setPlatformNumber(String platformNumber) {
        this.platformNumber = platformNumber == null ? null : platformNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emarket_pay_info.platform_status
     *
     * @return the value of emarket_pay_info.platform_status
     *
     * @mbg.generated Fri Nov 15 12:17:43 AEDT 2024
     */
    public String getPlatformStatus() {
        return platformStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emarket_pay_info.platform_status
     *
     * @param platformStatus the value for emarket_pay_info.platform_status
     *
     * @mbg.generated Fri Nov 15 12:17:43 AEDT 2024
     */
    public void setPlatformStatus(String platformStatus) {
        this.platformStatus = platformStatus == null ? null : platformStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emarket_pay_info.pay_amount
     *
     * @return the value of emarket_pay_info.pay_amount
     *
     * @mbg.generated Fri Nov 15 12:17:43 AEDT 2024
     */
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emarket_pay_info.pay_amount
     *
     * @param payAmount the value for emarket_pay_info.pay_amount
     *
     * @mbg.generated Fri Nov 15 12:17:43 AEDT 2024
     */
    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emarket_pay_info.create_time
     *
     * @return the value of emarket_pay_info.create_time
     *
     * @mbg.generated Fri Nov 15 12:17:43 AEDT 2024
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emarket_pay_info.create_time
     *
     * @param createTime the value for emarket_pay_info.create_time
     *
     * @mbg.generated Fri Nov 15 12:17:43 AEDT 2024
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emarket_pay_info.update_time
     *
     * @return the value of emarket_pay_info.update_time
     *
     * @mbg.generated Fri Nov 15 12:17:43 AEDT 2024
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emarket_pay_info.update_time
     *
     * @param updateTime the value for emarket_pay_info.update_time
     *
     * @mbg.generated Fri Nov 15 12:17:43 AEDT 2024
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}