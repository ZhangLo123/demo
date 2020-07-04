package com.example.demo.repository;

import com.example.demo.model.Images;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ImagesMapper {
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
