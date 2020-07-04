package com.example.demo.repository;

import com.example.demo.model.Proinfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProinfoMapper {
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
