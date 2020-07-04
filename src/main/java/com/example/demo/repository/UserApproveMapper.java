package com.example.demo.repository;

import com.example.demo.model.UserApprove;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserApproveMapper {

    List<UserApprove> findAllApprove();

    int putApply(UserApprove userApprove);
}
