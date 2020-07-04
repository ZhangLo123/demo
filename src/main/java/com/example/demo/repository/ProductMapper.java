package com.example.demo.repository;

import com.example.demo.model.Product;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductMapper {
    /**
     * 查找所有
     */
    List<Product> findAllPro();

    /**
     * 按name查找
     */
    List<Product> findBypName(String name);

    /**
     * 新增产品
     */
    int saveProduct(Product product);


}
