package com.example.smartcity_0715.pojo;

import com.google.gson.annotations.SerializedName;

public class PingLun {

    /**
     * searchValue : null
     * createBy : null
     * createTime : 2022-07-19 14:13:01
     * updateBy : null
     * updateTime : null
     * remark : null
     * params : {}
     * id : 132
     * userId : 1111223
     * libraryId : 10
     * content : 我很喜欢，也很怀念
     * myLikeState : false
     * userName : zby
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
    @SerializedName("userId")
    private Integer userId;
    @SerializedName("libraryId")
    private Integer libraryId;
    @SerializedName("content")
    private String content;
    @SerializedName("myLikeState")
    private Boolean myLikeState;
    @SerializedName("userName")
    private String userName;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean isMyLikeState() {
        return myLikeState;
    }

    public void setMyLikeState(Boolean myLikeState) {
        this.myLikeState = myLikeState;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static class ParamsDTO {
    }
}
