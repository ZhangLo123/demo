package com.example.demo.service.impl;

import com.example.demo.model.Images;
import com.example.demo.repository.ImagesMapper;
import com.example.demo.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ImagesServiceImpl implements ImagesService {
    @Autowired
    ImagesMapper imagesMapper;

    @Override
    public List<Images> findImage(Integer id) {
        return imagesMapper.findImage(id);
    }

    @Override
    public List<Images> findAllImage() {
        return imagesMapper.findAllImage();
    }

    @Override
    public int saveImage(Images images) {
        return imagesMapper.saveImage(images);
    }
}
