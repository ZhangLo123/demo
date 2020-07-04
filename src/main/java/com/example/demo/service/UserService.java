package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    User userLogin(String name);

    List<User> findAll();

//    int getUserCount();
//
//    List<User> findByuName(String name);

    int saveUser(User user);

    int updateUserNickname(User user);

    int updateUserface(User user);

    int updateUserBirthday(User user);

    int updateUserProvince(User user);

    int updateUserSex(User user);

    User findByuserId(String userId);

    int updateUserPhone(User user);
}
