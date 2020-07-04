package com.example.demo.service;

import com.example.demo.model.ShopUpload;

import java.util.List;

public interface ShopUploadService {
    /**
     * 查找所有
     */
    List<ShopUpload> findAllshop();

    /**
     * 查找
     */
    List<ShopUpload> findOneshop(String name);

    /**
     * 增加
     */
    int uploadShop(ShopUpload shopUp);

    /**
     * 删除
     */
    int delete(Integer id);
}
