package com.example.demo.model;


import java.time.LocalDate;

public class Images {
    private Integer Id;
    private String userId;
    private String pId;
    private String pShopname;
    private String imPathLunbo;
    private LocalDate imCreateTime;

    public Images() {
    }

    public Images(String userId, String pId, String pShopname, String imPathLunbo, LocalDate imCreateTime) {
        this.userId = userId;
        this.pId = pId;
        this.pShopname = pShopname;
        this.imPathLunbo = imPathLunbo;
        this.imCreateTime = imCreateTime;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpShopname() {
        return pShopname;
    }

    public void setpShopname(String pShopname) {
        this.pShopname = pShopname;
    }

    public String getImPathLunbo() {
        return imPathLunbo;
    }

    public void setImPathLunbo(String imPathLunbo) {
        this.imPathLunbo = imPathLunbo;
    }

    public LocalDate getImCreateTime() {
        return imCreateTime;
    }

    public void setImCreateTime(LocalDate imCreateTime) {
        this.imCreateTime = imCreateTime;
    }

    @Override
    public String toString() {
        return "Images{" +
                "Id=" + Id +
                ", userId='" + userId + '\'' +
                ", pId='" + pId + '\'' +
                ", pShopname='" + pShopname + '\'' +
                ", imPathLunbo='" + imPathLunbo + '\'' +
                ", imCreateTime=" + imCreateTime +
                '}';
    }
}
