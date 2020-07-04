package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductMapper;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> findAllPro() {
        return productMapper.findAllPro();
    }

    @Override
    public List<Product> findBypName(String name) {
        return productMapper.findBypName(name);
    }

    @Override
    public int saveProduct(Product product) {
        return productMapper.saveProduct(product);
    }
}
