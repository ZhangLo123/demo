package com.example.demo.service.impl;

import com.example.demo.model.WXUser;
import com.example.demo.repository.WXUserMapper;
import com.example.demo.service.WXUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WXUserServiceImpl implements WXUserService {

    @Autowired
    WXUserMapper wxUserMapper;

    @Override
    public int saveWXUser(WXUser wxUser) {
        return wxUserMapper.saveWXUser(wxUser);
    }

    @Override
    public WXUser findByOpenID(String openid) {
        return wxUserMapper.findByOpenID(openid);
    }
}
