package com.example.smartcity_0715.part.pojo;

import com.google.gson.annotations.SerializedName;

public class ParkSpace {


    /**
     * searchValue : null
     * createBy : null
     * createTime : null
     * updateBy : null
     * updateTime : null
     * remark : null
     * params : {}
     * id : 1
     * parkName : 国际大厦停车场
     * vacancy : 30
     * priceCaps : 30
     * imgUrl : /prod-api/profile/upload/image/2021/11/22/0e57fd23-1287-4bb5-a3e8-1222ab0ead40.jpg
     * rates : 5
     * address : 大连市国际大厦F1楼
     * distance : 20
     * allPark : 90
     * open : Y
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
    @SerializedName("parkName")
    private String parkName;
    @SerializedName("vacancy")
    private String vacancy;
    @SerializedName("priceCaps")
    private String priceCaps;
    @SerializedName("imgUrl")
    private String imgUrl;
    @SerializedName("rates")
    private String rates;
    @SerializedName("address")
    private String address;
    @SerializedName("distance")
    private String distance;
    @SerializedName("allPark")
    private String allPark;
    @SerializedName("open")
    private String open;

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

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getVacancy() {
        return vacancy;
    }

    public void setVacancy(String vacancy) {
        this.vacancy = vacancy;
    }

    public String getPriceCaps() {
        return priceCaps;
    }

    public void setPriceCaps(String priceCaps) {
        this.priceCaps = priceCaps;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getRates() {
        return rates;
    }

    public void setRates(String rates) {
        this.rates = rates;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getAllPark() {
        return allPark;
    }

    public void setAllPark(String allPark) {
        this.allPark = allPark;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public static class ParamsDTO {
    }
}
