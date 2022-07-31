package com.example.smartcity_0715.film.pojo;

import com.google.gson.annotations.SerializedName;

public class Movie {

    /**
     * searchValue : null
     * createBy : null
     * createTime : null
     * updateBy : null
     * updateTime : null
     * remark : null
     * params : {}
     * id : 2
     * name : 变形金刚
     * category : 8
     * cover : /prod-api/profile/upload/image/2021/04/07/c7fba3ca-59bb-4e25-9b8f-237ca7a99970.png
     * playType : 1
     * score : 4
     * duration : 180
     * playDate : 2021-04-08
     * likeNum : 121
     * favoriteNum : 206
     * language : 英文
     * introduction : <p>请问恶趣味翁翁</p>
     * other : null
     * recommend : Y
     */

    @SerializedName("searchValue")
    private Object searchValue;
    @SerializedName("createBy")
    private Object createBy;
    @SerializedName("createTime")
    private Object createTime;
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
    @SerializedName("name")
    private String name;
    @SerializedName("category")
    private String category;
    @SerializedName("cover")
    private String cover;
    @SerializedName("playType")
    private String playType;
    @SerializedName("score")
    private Integer score;
    @SerializedName("duration")
    private Integer duration;
    @SerializedName("playDate")
    private String playDate;
    @SerializedName("likeNum")
    private Integer likeNum;
    @SerializedName("favoriteNum")
    private Integer favoriteNum;
    @SerializedName("language")
    private String language;
    @SerializedName("introduction")
    private String introduction;
    @SerializedName("other")
    private Object other;
    @SerializedName("recommend")
    private String recommend;

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

    public Object getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Object createTime) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getPlayType() {
        return playType;
    }

    public void setPlayType(String playType) {
        this.playType = playType;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getPlayDate() {
        return playDate;
    }

    public void setPlayDate(String playDate) {
        this.playDate = playDate;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getFavoriteNum() {
        return favoriteNum;
    }

    public void setFavoriteNum(Integer favoriteNum) {
        this.favoriteNum = favoriteNum;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Object getOther() {
        return other;
    }

    public void setOther(Object other) {
        this.other = other;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public static class ParamsDTO {
    }
}
