package com.example.smartcity_0715.pojo;

import com.google.gson.annotations.SerializedName;

public class OrderBus {

    /**
     * searchValue : null
     * createBy : null
     * createTime : 2022-05-07 16:55:14
     * updateBy : null
     * updateTime : null
     * remark : null
     * params : {}
     * id : 4653
     * orderNum : 91371395
     * path : 一号线
     * start : 泰德大厦
     * end : 大连北站
     * price : 9.0
     * userName : Mikasa
     * userTel : 13022478989
     * userId : 1115701
     * status : 0
     * paymentType : null
     * payTime : null
     */

    @SerializedName("searchValue")
    private Object searchValue;
    @SerializedName("createBy")
    private Object createBy;
    @SerializedName("createTime")
    private String createTime;
    @SerializedName("updateBy")
    private Object updateBy;
    @SerializedName("updateTime")
    private Object updateTime;
    @SerializedName("remark")
    private Object remark;
    @SerializedName("params")
    private ParamsDTO params;
    @SerializedName("id")
    private Integer id;
    @SerializedName("orderNum")
    private String orderNum;
    @SerializedName("path")
    private String path;
    @SerializedName("start")
    private String start;
    @SerializedName("end")
    private String end;
    @SerializedName("price")
    private Double price;
    @SerializedName("userName")
    private String userName;
    @SerializedName("userTel")
    private String userTel;
    @SerializedName("userId")
    private Integer userId;
    @SerializedName("status")
    private Integer status;
    @SerializedName("paymentType")
    private Object paymentType;
    @SerializedName("payTime")
    private Object payTime;

    public Object getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(Object searchValue) {
        this.searchValue = searchValue;
    }

    public Object getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Object createBy) {
        this.createBy = createBy;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Object getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Object updateBy) {
        this.updateBy = updateBy;
    }

    public Object getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Object updateTime) {
        this.updateTime = updateTime;
    }

    public Object getRemark() {
        return remark;
    }

    public void setRemark(Object remark) {
        this.remark = remark;
    }

    public ParamsDTO getParams() {
        return params;
    }

    public void setParams(ParamsDTO params) {
        this.params = params;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Object paymentType) {
        this.paymentType = paymentType;
    }

    public Object getPayTime() {
        return payTime;
    }

    public void setPayTime(Object payTime) {
        this.payTime = payTime;
    }

    public static class ParamsDTO {
    }
}
