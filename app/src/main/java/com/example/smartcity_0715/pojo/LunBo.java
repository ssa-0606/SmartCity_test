package com.example.smartcity_0715.pojo;

import com.google.gson.annotations.SerializedName;

public class LunBo {


    /**
     * searchValue : null
     * createBy : admin
     * createTime : 2021-05-06 15:40:17
     * updateBy : 1
     * updateTime : 2021-06-25 11:02:40
     * remark : null
     * params : {}
     * id : 25
     * appType : smart_city
     * status : 1
     * sort : 2
     * advTitle : 首页轮播
     * advImg : /prod-api/profile/upload/image/2021/05/06/b9d9f081-8a76-41dc-8199-23bcb3a64fcc.png
     * servModule : 新闻详情
     * targetId : 28
     * type : 2
     */

    @SerializedName("searchValue")
    private Object searchValue;
    @SerializedName("createBy")
    private String createBy;
    @SerializedName("createTime")
    private String createTime;
    @SerializedName("updateBy")
    private String updateBy;
    @SerializedName("updateTime")
    private String updateTime;
    @SerializedName("remark")
    private Object remark;
    @SerializedName("params")
    private ParamsDTO params;
    @SerializedName("id")
    private Integer id;
    @SerializedName("appType")
    private String appType;
    @SerializedName("status")
    private String status;
    @SerializedName("sort")
    private Integer sort;
    @SerializedName("advTitle")
    private String advTitle;
    @SerializedName("advImg")
    private String advImg;
    @SerializedName("servModule")
    private String servModule;
    @SerializedName("targetId")
    private Integer targetId;
    @SerializedName("type")
    private String type;

    public Object getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(Object searchValue) {
        this.searchValue = searchValue;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
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

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getAdvTitle() {
        return advTitle;
    }

    public void setAdvTitle(String advTitle) {
        this.advTitle = advTitle;
    }

    public String getAdvImg() {
        return advImg;
    }

    public void setAdvImg(String advImg) {
        this.advImg = advImg;
    }

    public String getServModule() {
        return servModule;
    }

    public void setServModule(String servModule) {
        this.servModule = servModule;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class ParamsDTO {
    }
}
