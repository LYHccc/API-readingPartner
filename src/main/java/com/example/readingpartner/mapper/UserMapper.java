package com.example.readingpartner.mapper;

import com.example.readingpartner.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    /**
     * 根据用户名和密码查询用户
     */
    User selectUser(@Param("mobile") String mobile,@Param("password") String password);

    /**
     * 根据用户名查询用户
     */
    User selectByMobile(String mobile);
}