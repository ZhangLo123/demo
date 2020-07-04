package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public User userLogin(String name) {
        return userMapper.userLogin(name);
    }

    @Override
    public List<User> findAll() {

        return userMapper.findAll();
    }

//    @Override
//    public int getUserCount() {
//        return userMapper.getUserCount();
//    }
//
//    @Override
//    public List<User> findByuName(String name) {
//        return userMapper.findByuName(name);
//    }

    @Override
    public int saveUser(User user) {
        return userMapper.saveUser(user);
    }

    @Override
    public int updateUserNickname(User user) {
        return userMapper.updateUserNickname(user);
    }

    @Override
    public int updateUserface(User user) {
        return userMapper.updateUserface(user);
    }

    @Override
    public int updateUserBirthday(User user) {
        return userMapper.updateUserBirthday(user);
    }

    @Override
    public int updateUserProvince(User user) {
        return userMapper.updateUserProvince(user);
    }

    @Override
    public int updateUserSex(User user) {
        return userMapper.updateUserSex(user);
    }


    @Override
    public User findByuserId(String userId) {
        return userMapper.findByuserId(userId);
    }

    @Override
    public int updateUserPhone(User user) {
        return userMapper.updateUserPhone(user);
    }

//    @Override
//    public List<User> findById(Integer id) {
//        return userMapper.findById(id);
//    }
}
