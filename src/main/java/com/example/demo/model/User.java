package com.example.demo.model;

import java.time.LocalDate;


public class User {
    private Integer Id;
    private String uId;
    private String uName;
    private String uPassWord;
    private String uPhone;
    private String uHeadimage;
    private Integer uSex;
    private String uBirthday;
    private String uProvince;
    private String uToken;
    private String uLimit;
    private String uRegtime;

    public User() {
    }

    public User(String uId, String uName, String uHeadimage, Integer uSex, String uBirthday, String uProvince, String uToken) {
        this.uId = uId;
        this.uName = uName;
        this.uHeadimage = uHeadimage;
        this.uSex = uSex;
        this.uBirthday = uBirthday;
        this.uProvince = uProvince;
        this.uToken = uToken;
    }

    public User(String uId, String uName, String uPassWord, String uToken, String uRegtime) {
        this.uId = uId;
        this.uName = uName;
        this.uPassWord = uPassWord;
        this.uToken = uToken;
        this.uRegtime = uRegtime;
    }

    public User(String uId, String uName, String uPassWord, String uHeadimage, Integer uSex, String uBirthday, String uProvince, String uToken, String uRegtime) {
        this.uId = uId;
        this.uName = uName;
        this.uPassWord = uPassWord;
        this.uHeadimage = uHeadimage;
        this.uSex = uSex;
        this.uBirthday = uBirthday;
        this.uProvince = uProvince;
        this.uToken = uToken;
        this.uRegtime = uRegtime;
    }

    public User(Integer id, String uId, String uName, String uPassWord, String uHeadimage, String uToken, String uLimit) {
        Id = id;
        this.uId = uId;
        this.uName = uName;
        this.uPassWord = uPassWord;
        this.uHeadimage = uHeadimage;
        this.uToken = uToken;
        this.uLimit = uLimit;
    }

    public User(String uId, String uPhone, String uToken) {
        this.uId = uId;
        this.uPhone = uPhone;
        this.uToken = uToken;
    }

    public User(String uId, String uName, String uToken, String uLimit) {
        this.uId = uId;
        this.uName = uName;
        this.uToken = uToken;
        this.uLimit = uLimit;
    }



    public String getuLimit() {
        return uLimit;
    }

    public void setuLimit(String uLimit) {
        this.uLimit = uLimit;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getuHeadimage() {
        return uHeadimage;
    }

    public void setuHeadimage(String uHeadimage) {
        this.uHeadimage = uHeadimage;
    }

    public Integer getuSex() {
        return uSex;
    }

    public void setuSex(Integer uSex) {
        this.uSex = uSex;
    }

    public String getuBirthday() {
        return uBirthday;
    }

    public void setuBirthday(String uBirthday) {
        this.uBirthday = uBirthday;
    }

    public String getuProvince() {
        return uProvince;
    }

    public void setuProvince(String uProvince) {
        this.uProvince = uProvince;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassWord() {
        return uPassWord;
    }

    public void setuPassWord(String uPassWord) {
        this.uPassWord = uPassWord;
    }

    public String getuRegtime() {
        return uRegtime;
    }

    public void setuRegtime(String uRegtime) {
        this.uRegtime = uRegtime;
    }

    public String getuToken() {
        return uToken;
    }

    public void setuToken(String uToken) {
        this.uToken = uToken;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", uId='" + uId + '\'' +
                ", uName='" + uName + '\'' +
                ", uPassWord='" + uPassWord + '\'' +
                ", uPhone='" + uPhone + '\'' +
                ", uHeadimage='" + uHeadimage + '\'' +
                ", uSex=" + uSex +
                ", uBirthday='" + uBirthday + '\'' +
                ", uProvince='" + uProvince + '\'' +
                ", uToken='" + uToken + '\'' +
                ", uRegtime=" + uRegtime +
                '}';
    }
}
