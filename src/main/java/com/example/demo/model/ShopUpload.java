package com.example.demo.model;

public class ShopUpload {
    private Integer Id;
    private String userId;
    private String shopName;
    private Integer shopPrice;
    private String shopFactory;
    private String shopInfo;
    private String shopImagesZhutu;
    private long shopCreateTime;

    public ShopUpload() {
    }

    public ShopUpload(String userId, String shopName, Integer shopPrice, String shopFactory, String shopInfo, long shopCreateTime) {
        this.userId = userId;
        this.shopName = shopName;
        this.shopPrice = shopPrice;
        this.shopFactory = shopFactory;
        this.shopInfo = shopInfo;
        this.shopCreateTime = shopCreateTime;
    }

    public ShopUpload(String userId, String shopName, Integer shopPrice, String shopFactory, String shopInfo, String shopImagesZhutu, long shopCreateTime) {
        this.userId = userId;
        this.shopName = shopName;
        this.shopPrice = shopPrice;
        this.shopFactory = shopFactory;
        this.shopInfo = shopInfo;
        this.shopImagesZhutu = shopImagesZhutu;
        this.shopCreateTime = shopCreateTime;
    }

    public ShopUpload(Integer id, String userId, String shopName, Integer shopPrice, String shopFactory, String shopInfo, String shopImagesZhutu, long shopCreateTime) {
        Id = id;
        this.userId = userId;
        this.shopName = shopName;
        this.shopPrice = shopPrice;
        this.shopFactory = shopFactory;
        this.shopInfo = shopInfo;
        this.shopImagesZhutu = shopImagesZhutu;
        this.shopCreateTime = shopCreateTime;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public long getShopCreateTime() {
        return shopCreateTime;
    }

    public void setShopCreateTime(long shopCreateTime) {
        this.shopCreateTime = shopCreateTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(Integer shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getShopFactory() {
        return shopFactory;
    }

    public void setShopFactory(String shopFactory) {
        this.shopFactory = shopFactory;
    }

    public String getShopInfo() {
        return shopInfo;
    }

    public void setShopInfo(String shopInfo) {
        this.shopInfo = shopInfo;
    }

    public String getShopImagesZhutu() {
        return shopImagesZhutu;
    }

    public void setShopImagesZhutu(String shopImagesZhutu) {
        this.shopImagesZhutu = shopImagesZhutu;
    }


    @Override
    public String toString() {
        return "ShopUpload{" +
                "Id=" + Id +
                ", userId=" + userId +
                ", shopName='" + shopName + '\'' +
                ", shopPrice=" + shopPrice +
                ", shopFactory='" + shopFactory + '\'' +
                ", shopInfo='" + shopInfo + '\'' +
                ", shopImagesZhutu='" + shopImagesZhutu + '\'' +
                ", shopCreateTime=" + shopCreateTime +
                '}';
    }
}
