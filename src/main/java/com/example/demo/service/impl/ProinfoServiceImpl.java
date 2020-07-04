package com.example.demo.service.impl;

import com.example.demo.model.Proinfo;
import com.example.demo.repository.ProinfoMapper;
import com.example.demo.service.ProinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProinfoServiceImpl implements ProinfoService {

    @Autowired
    ProinfoMapper proinfoMapper;

    @Override
    public List<Proinfo> findAllShop() {
        return proinfoMapper.findAllShop();
    }

    @Override
    public List<Proinfo> findOneShop(String name) {
        return proinfoMapper.findOneShop(name);
    }

    @Override
    public List<Proinfo> findOneUser(String userId) {
        return proinfoMapper.findOneUser(userId);
    }

    @Override
    public int UploadShop(Proinfo proinfo) {
        return proinfoMapper.UploadShop(proinfo);
    }

    @Override
    public int updatemainImage(Proinfo proinfo) {
        return proinfoMapper.updatemainImage(proinfo);
    }

    @Override
    public int updatecarouselImages(Proinfo proinfo) {
        return proinfoMapper.updatecarouselImages(proinfo);
    }

    @Override
    public int delete(Integer id) {
        return proinfoMapper.delete(id);
    }
}
