package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {
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
