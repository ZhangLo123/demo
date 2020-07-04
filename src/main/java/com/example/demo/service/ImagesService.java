package com.example.demo.service;

import com.example.demo.model.Images;

import java.util.List;

public interface ImagesService {
    /**
     * 查找
     */
    List<Images> findImage(Integer id);

    /**
     * 查找所有
     */
    List<Images> findAllImage();

    /**
     * 插入
     */
    int saveImage(Images images);
}
