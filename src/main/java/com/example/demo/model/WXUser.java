package com.example.demo.model;

import java.time.LocalDate;

public class WXUser {
    private Integer Id;
    private String openId;
    private String wxUserId;
    private String nickName;
    private String gender;
    private String faceUrl;
    private String wxCreateTime;

    public WXUser() {
    }

    public WXUser(String nickName, String gender, String faceUrl, String wxCreateTime) {
        this.nickName = nickName;
        this.gender = gender;
        this.faceUrl = faceUrl;
        this.wxCreateTime = wxCreateTime;
    }

    public WXUser(String openId,String wxUserId, String nickName, String gender, String faceUrl, String wxCreateTime) {
        this.openId = openId;
        this.wxUserId = wxUserId;
        this.nickName = nickName;
        this.gender = gender;
        this.faceUrl = faceUrl;
        this.wxCreateTime = wxCreateTime;
    }

    public WXUser(Integer id, String openId, String nickName, String gender, String faceUrl,String wxCreateTime) {
        Id = id;
        this.openId = openId;
        this.nickName = nickName;
        this.gender = gender;
        this.faceUrl = faceUrl;
        this.wxCreateTime = wxCreateTime;
    }

    public String getWxUserId() {
        return wxUserId;
    }

    public void setWxUserId(String wxUserId) {
        this.wxUserId = wxUserId;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    public String getWxCreateTime() {
        return wxCreateTime;
    }

    public void setWxCreateTime(String wxCreateTime) {
        this.wxCreateTime = wxCreateTime;
    }

    @Override
    public String toString() {
        return "WXUser{" +
                "Id=" + Id +
                ", openId='" + openId + '\'' +
                ", wxUserId='" + wxUserId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", gender='" + gender + '\'' +
                ", faceUrl='" + faceUrl + '\'' +
                ", wxCreateTime=" + wxCreateTime +
                '}';
    }
}
