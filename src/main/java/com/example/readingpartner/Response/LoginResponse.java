package com.example.readingpartner.Response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.StringWriter;

@Getter
@Setter
@Data
public class LoginResponse {
    private String msg;
    private int code;
    private int expire;
    private String token;

    private LoginResponse(){}
    //登录成功
    public static LoginResponse ok(String token) {
        LoginResponse response = new LoginResponse();
        response.code = 0;
        response.msg = "success";
        response.token = token;
        return response;
    }

    //登录成功
    public static LoginResponse ok() {
        return LoginResponse.ok("");
    }

    //登录失败
    public static LoginResponse fail(String msg) {
        LoginResponse response = new LoginResponse();
        response.code = 500;
        response.msg = msg;
        response.token = "";
        return response;
    }

    //捕获到异常返回错误信息
    public static LoginResponse error(Exception e) {
        LoginResponse response = new LoginResponse();
        response.code = 500;
        StringWriter sw = new StringWriter();
        e.printStackTrace();
        response.msg = "error:" + sw.toString();
        return response;
    }
}
