package com.example.readingpartner.service;

import com.example.readingpartner.mapper.UserMapper;
import com.example.readingpartner.Response.LoginResponse;
import com.example.readingpartner.model.User;
import com.example.readingpartner.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public LoginResponse login(User user) {
        String mobile = user.getMobile().trim();
        String password = user.getPassword().trim();
        if (mobile.length() <= 0 || password.length() <= 0)
            return LoginResponse.fail("用户名和密码不能为空，请重新输入");
        User u = userMapper.selectUser(mobile, password);
        if (u == null) {
            return LoginResponse.fail("用户名或密码错误，请重新输入");
        }
        return LoginResponse.ok(u.getToken());
    }

    public LoginResponse register(User user) {
        String mobile = user.getMobile().trim();
        String password = user.getPassword().trim();
        if (mobile.length() <= 0 || password.length() <= 0)
            return LoginResponse.fail("用户名和密码不能为空，请重新输入");
        User u = userMapper.selectByMobile(mobile);
        if (u != null) {
            return LoginResponse.fail("用户已存在，请重新输入");
        }
        String token = TokenUtil.getToken(mobile, password);
        user.setToken(token);
        userMapper.insert(user);
        return LoginResponse.ok();
    }
}
