package com.example.demo.service.impl;

import com.example.demo.model.ShopUpload;
import com.example.demo.repository.ShopUploadMapper;
import com.example.demo.service.ShopUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ShopUploadServiceImpl implements ShopUploadService {

    @Autowired
    ShopUploadMapper shopUploadMapper;


    @Override
    public List<ShopUpload> findAllshop() {
        return shopUploadMapper.findAllshop();
    }

    @Override
    public List<ShopUpload> findOneshop(String name) {
        return shopUploadMapper.findOneshop(name);
    }

    @Override
    public int uploadShop(ShopUpload shopUp) {
        return shopUploadMapper.uploadShop(shopUp);
    }

    @Override
    public int delete(Integer id) {
        return shopUploadMapper.delete(id);
    }
}
