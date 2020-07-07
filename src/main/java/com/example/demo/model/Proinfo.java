package com.example.demo.model;

import java.time.LocalDate;

public class Proinfo {
    private Integer Id;
    private String userId;
    private String userToken;
    private String shopId;
    private String shopName;
    private String shopPrice;
    private String shopFactory;
    private String contact;
    private String volt;
    private String aisle;
    private String weight;
    private String system;
    private String profile;
    private String application;
    private String features;
    private String mainImage;
    private String carouselImages;
    private String uploadTime;

    public Proinfo() {
    }

    public Proinfo(String userId, String userToken, String shopId, String shopName, String shopPrice, String shopFactory, String contact, String volt, String aisle, String weight, String system, String profile, String application, String features, String uploadTime) {
        this.userId = userId;
        this.userToken = userToken;
        this.shopId = shopId;
        this.shopName = shopName;
        this.shopPrice = shopPrice;
        this.shopFactory = shopFactory;
        this.contact = contact;
        this.volt = volt;
        this.aisle = aisle;
        this.weight = weight;
        this.system = system;
        this.profile = profile;
        this.application = application;
        this.features = features;
        this.uploadTime = uploadTime;
    }

    public Proinfo(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
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

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(String shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getShopFactory() {
        return shopFactory;
    }

    public void setShopFactory(String shopFactory) {
        this.shopFactory = shopFactory;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getVolt() {
        return volt;
    }

    public void setVolt(String volt) {
        this.volt = volt;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getCarouselImages() {
        return carouselImages;
    }

    public void setCarouselImages(String carouselImages) {
        this.carouselImages = carouselImages;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Override
    public String toString() {
        return "Proinfo{" +
                "Id=" + Id +
                ", userId='" + userId + '\'' +
                ", userToken='" + userToken + '\'' +
                ", shopId='" + shopId + '\'' +
                ", shopName='" + shopName + '\'' +
                ", shopPrice='" + shopPrice + '\'' +
                ", shopFactory='" + shopFactory + '\'' +
                ", contact='" + contact + '\'' +
                ", volt='" + volt + '\'' +
                ", aisle='" + aisle + '\'' +
                ", weight='" + weight + '\'' +
                ", system='" + system + '\'' +
                ", profile='" + profile + '\'' +
                ", application='" + application + '\'' +
                ", features='" + features + '\'' +
                ", mainImage='" + mainImage + '\'' +
                ", carouselImages='" + carouselImages + '\'' +
                ", uploadTime=" + uploadTime +
                '}';
    }
}
