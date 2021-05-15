package com.example.readingpartner.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.HashMap;
import java.util.Map;

public class TokenUtil {
    //token秘钥
    private static final String TOKEN_SECRET = "EQIUBFKSJBFJH2367816BQWE";

    public static String getToken(String mobile, String password) {
        String token = "";
        try {
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String,Object> header = new HashMap<>();
            header.put("typ","JWT");
            header.put("alg","HS256");
            //携带username，password信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("mobile",mobile)
                    .withClaim("password",password)
                    .sign(algorithm);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
        return token;
    }
}
