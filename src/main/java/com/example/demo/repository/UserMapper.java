package com.example.demo.repository;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    /**
     * 登录
     */
    User userLogin(String name);

    /**
     * 查找所有
     * @return
     */
    List<User> findAll();

//    /**
//     * 按用户名查找
//     */
//    List<User> findByuName(String name);
//
    /**
     * 按userId查找
     */
    User findByuserId(String userId);

    /**
     * 插入
     */
    int saveUser(User user);

//    /**
//     * 删除
//     */
//    int delete(Integer uId);
//
    /**
     * 更新昵称
     */
    int updateUserNickname(User user);

    /**
     * 上传头像
     */
    int updateUserface(User user);

    /**
     * 更新生日
     */
    int updateUserBirthday(User user);

    /**
     * 更新城市
     */
    int updateUserProvince(User user);

    /**
     * 更新性别
     */
    int updateUserSex(User user);

    /**
     * 更新手机号
     */
    int updateUserPhone(User user);

//
//    /**
//     * 总的数量
//     */
//    int getUserCount();


}
