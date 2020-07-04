package com.example.demo.model;



public class Product {
    private Integer Id;
    private String pId;
    private String pName;
    private Integer price;
    private String factory;
    private String service;
    private String image;

    public Product() {
    }

    public Product(String pId, String pName, Integer price, String factory, String service, String image) {
        this.pId = pId;
        this.pName = pName;
        this.price = price;
        this.factory = factory;
        this.service = service;
        this.image = image;
    }

    public Product(Integer id, String pId, String pName, Integer price, String factory, String service, String image) {
        Id = id;
        this.pId = pId;
        this.pName = pName;
        this.price = price;
        this.factory = factory;
        this.service = service;
        this.image = image;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Id=" + Id +
                ", pId='" + pId + '\'' +
                ", pName='" + pName + '\'' +
                ", price=" + price +
                ", factory='" + factory + '\'' +
                ", service='" + service + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
