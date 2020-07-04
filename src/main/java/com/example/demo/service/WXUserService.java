package com.example.demo.service;

import com.example.demo.model.WXUser;

import java.util.List;

public interface WXUserService {
    int saveWXUser(WXUser wxUser);

    WXUser findByOpenID(String openid);
}
