package com.example.demo.service.impl;

import com.example.demo.model.UserApprove;
import com.example.demo.repository.UserApproveMapper;
import com.example.demo.service.UserApproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserApproveServiceImpl implements UserApproveService {

    @Autowired
    private UserApproveMapper userApproveMapper;

    @Override
    public List<UserApprove> findAllApprove() {
        return userApproveMapper.findAllApprove();
    }

    @Override
    public int putApply(UserApprove userApprove) {
        return userApproveMapper.putApply(userApprove);
    }

    @Override
    public List<UserApprove> findApprove(String uId) {
        return userApproveMapper.findApprove(uId);
    }

    @Override
    public UserApprove findOneApprove(String uId) {
        return userApproveMapper.findOneApprove(uId);
    }

    @Override
    public int updateApprove(UserApprove userApprove) {
        return userApproveMapper.updateApprove(userApprove);
    }
}
