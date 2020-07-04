package com.example.demo.repository;

import com.example.demo.model.WXUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WXUserMapper {
    //存入用户
    int saveWXUser(WXUser wxUser);

    WXUser findByOpenID(String openid);

//    WXUser findOne(WXUser wxUser);
}
