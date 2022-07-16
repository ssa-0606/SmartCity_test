package com.example.smartcity_0715.pojo;

import com.google.gson.annotations.SerializedName;

public class CityService {


    /**
     * searchValue : null
     * createBy : null
     * createTime : 2020-10-23 16:17:56
     * updateBy : null
     * updateTime : 2021-05-10 09:20:12
     * remark : null
     * params : {}
     * id : 17
     * serviceName : 停哪儿
     * serviceDesc : 查询停车场
     * serviceType : 车主服务
     * imgUrl : /prod-api/profile/upload/image/2021/05/10/814fc6c4-de48-48a1-95f8-de3e749e348d.png
     * pid : 1
     * link : park/index
     * sort : 0
     * isRecommend : N
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
    private String updateTime;
    @SerializedName("remark")
    private Object remark;
    @SerializedName("params")
    private ParamsDTO params;
    @SerializedName("id")
    private Integer id;
    @SerializedName("serviceName")
    private String serviceName;
    @SerializedName("serviceDesc")
    private String serviceDesc;
    @SerializedName("serviceType")
    private String serviceType;
    @SerializedName("imgUrl")
    private String imgUrl;
    @SerializedName("pid")
    private Integer pid;
    @SerializedName("link")
    private String link;
    @SerializedName("sort")
    private Integer sort;
    @SerializedName("isRecommend")
    private String isRecommend;

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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(String isRecommend) {
        this.isRecommend = isRecommend;
    }

    public static class ParamsDTO {
    }
}
