package com.example.demo.service;

import com.example.demo.model.Proinfo;

import java.util.List;

public interface ProinfoService {
    /**
     * 查找所有
     */
    List<Proinfo> findAllShop();

    /**
     * 查找产品
     */
    List<Proinfo> findOneShop(String name);

    /**
     * 查找用户
     */
    List<Proinfo> findOneUser(String userId);

    /**
     * 增加
     */
    int UploadShop(Proinfo proinfo);

    /**
     * 更新主图
     */
    int updatemainImage(Proinfo proinfo);

    /**
     * 更新轮播图
     */
    int updatecarouselImages(Proinfo proinfo);

    /**
     * 删除
     */
    int delete(Integer id);
}
