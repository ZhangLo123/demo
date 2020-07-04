package com.example.demo.utils;


public class UserDataInfo {

    private String userId;
    private String userName;
    private String token;

    public UserDataInfo(String userId, String userName, String token) {
        this.userId = userId;
        this.userName = userName;
        this.token = token;
    }

    public UserDataInfo(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserDataInfo{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
