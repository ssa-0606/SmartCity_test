package com.example.smartcity_0715.event.pojo;

import com.google.gson.annotations.SerializedName;

public class Event {

    /**
     * searchValue : null
     * createBy : admin
     * createTime : 2021-05-08 13:59:44
     * updateBy : 1119697
     * updateTime : 2022-07-08 16:02:00
     * remark : null
     * params : {}
     * id : 47
     * name : 《大数据+医疗卫生》线上免费录播课，了解在医疗行业的大数据
     * content : <p>大数据的增长让人们做了-些不可思议的事情。采用大数据，机器学习可以预测财产损失和检测欺诈，甚至预测未来的天气事件。然而，这些算法最令人难以置信的应用可能是在医疗保健领域。</p><p><strong>拯救生命的预测</strong></p><p>通过提供另-一个视角，数据驱动的机器学习算法可以提供关键的二次反馈，并有助于早期检测。例如，中国的研究人员已经开始使用机器学习算法来预测患者从昏迷中醒来的可能性。在一些情况下，该算法正确地预测了医护人员不在时患者是否会醒来。尽管有时算法是错误的，医生的判断是正确的，但人工智能仍然足够准确，可以为临床诊断提供宝贵的第二种意见。</p><p>医疗健康的图像数据对于机器学习尤其有价值。例如，当由眼科医生进行评估时，深度学习算法通过学习数千张视网膜照片,对糖尿病性视网膜病变具有超过90%的特异性和敏感性得以判断分析。在皮肤病的研究中，当在输入130,000张患者图像之后，机器学习的一-种算法在识别皮肤癌方面和皮肤科医生一样准确。 虽然提供不受人为错误影响的第二种意见无疑是有帮助的，但这些算法正在提供医生已经提供的诊断服务。这带来了一个问题:机器学习是否可以在医生无法提供帮助的领域提供帮助?</p><p>下面这个课程通过对大数据在医疗业务背景的介绍，业务架构、技术.选型、数据采集、报文处理、预警报警等模块的讲解,使学员了解大数据如何与医疗卫生相结合。本课程为线上录播课，可添加微信或者直接报名，助教老师会把课程链接和账号密码以短信的内容发送到您的手机或者微信，注意查收哟！</p>
     * imgUrl : /prod-api/profile/upload/image/2021/05/08/259f19fe-03ba-4cc9-ba51-65cd54d0eb00.jpg
     * categoryId : 5
     * recommend : Y
     * signupNum : 572
     * likeNum : 756
     * status : 1
     * publishTime : 2021-05-08 13:59:44
     * categoryName : 行业
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
    @SerializedName("name")
    private String name;
    @SerializedName("content")
    private String content;
    @SerializedName("imgUrl")
    private String imgUrl;
    @SerializedName("categoryId")
    private Integer categoryId;
    @SerializedName("recommend")
    private String recommend;
    @SerializedName("signupNum")
    private Integer signupNum;
    @SerializedName("likeNum")
    private Integer likeNum;
    @SerializedName("status")
    private String status;
    @SerializedName("publishTime")
    private String publishTime;
    @SerializedName("categoryName")
    private String categoryName;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public Integer getSignupNum() {
        return signupNum;
    }

    public void setSignupNum(Integer signupNum) {
        this.signupNum = signupNum;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public static class ParamsDTO {
    }
}
