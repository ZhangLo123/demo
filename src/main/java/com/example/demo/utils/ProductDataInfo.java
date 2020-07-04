package com.example.demo.utils;

import java.util.List;

public class ProductDataInfo<T> {

    private List<T> productInfo;

    public ProductDataInfo(List<T> productInfo) {
        this.productInfo = productInfo;
    }

    public ProductDataInfo() {
    }

    public List<T> getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(List<T> productInfo) {
        this.productInfo = productInfo;
    }
}
