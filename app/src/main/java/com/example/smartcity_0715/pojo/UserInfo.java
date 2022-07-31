package com.example.smartcity_0715.pojo;

import com.google.gson.annotations.SerializedName;

public class UserInfo {


    /**
     * userId : 1115701
     * userName : Mikasa
     * nickName : Mikasa
     * email : WOSHIMAHUATENG@qq.com
     * phonenumber :
     * sex : 0
     * avatar : http://124.93.196.45/profile/upload/2022/06/23/2b56a1bd-e687-467b-9bf7-8ae351da2af4.jpg
     * idCard : 210113199909091234
     * balance : 20791.0
     * score : 720
     */

    @SerializedName("userId")
    private Integer userId;
    @SerializedName("userName")
    private String userName;
    @SerializedName("nickName")
    private String nickName;
    @SerializedName("email")
    private String email;
    @SerializedName("phonenumber")
    private String phonenumber;
    @SerializedName("sex")
    private String sex;
    @SerializedName("avatar")
    private String avatar;
    @SerializedName("idCard")
    private String idCard;
    @SerializedName("balance")
    private Double balance;
    @SerializedName("score")
    private Integer score;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
