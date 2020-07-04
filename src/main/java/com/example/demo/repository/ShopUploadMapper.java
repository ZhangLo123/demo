package com.example.demo.repository;

import com.example.demo.model.ShopUpload;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShopUploadMapper {
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
