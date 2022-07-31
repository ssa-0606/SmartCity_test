package com.example.smartcity_0715.event.pojo;

import com.google.gson.annotations.SerializedName;

public class Comment {

    /**
     * searchValue : null
     * createBy : null
     * createTime : 2022-07-04 20:55:40
     * updateBy : null
     * updateTime : null
     * remark : null
     * params : {}
     * id : 88
     * userId : 1111151
     * activityId : 50
     * content : 121213123123
     * commentTime : 2022-07-04 20:55:40
     * activityName : 你想在20/30多岁的时候安定下来，拥有理想的工作，有合适的伴侣，有美好的生活方式吗?
     * userName : 114514
     * nickName : 114511412
     * avatar :
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
    @SerializedName("activityId")
    private Integer activityId;
    @SerializedName("content")
    private String content;
    @SerializedName("commentTime")
    private String commentTime;
    @SerializedName("activityName")
    private String activityName;
    @SerializedName("userName")
    private String userName;
    @SerializedName("nickName")
    private String nickName;
    @SerializedName("avatar")
    private String avatar;

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

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public static class ParamsDTO {
    }
}
