package com.example.demo.service;

import com.example.demo.model.UserApprove;

import java.util.List;

public interface UserApproveService {

    List<UserApprove> findAllApprove();

    int putApply(UserApprove userApprove);

    List<UserApprove> findApprove(String uId);

    UserApprove findOneApprove(String uId);

    int updateApprove(UserApprove userApprove);
}
