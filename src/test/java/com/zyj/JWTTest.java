package com.zyj;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JWTTest {

    @Test
    void test1()throws Exception{
        String token = null;
        token = JWT.create()
                .withClaim("userID", 9876)
                .withClaim("userName", "sun xiao chuan")
                .withExpiresAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-8-10 23:06:30"))
                .sign(Algorithm.HMAC256("zyj1996"));

        System.out.println(token);
    }

    @Test
    void test2(){
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("zyj1996")).build();
        DecodedJWT decodedJWT = verifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyTmFtZSI6InN1biB4aWFvIGNodWFuIiwiZXhwIjoxNTk3MDcxOTkwLCJ1c2VySUQiOjk4NzZ9.lKAMUwe7t_Nrq3UCyQeBxuq5EqmXKrL7p1JHQYcx7PE");
        System.out.println(decodedJWT.getClaim("userID").asInt());
        System.out.println(decodedJWT.getClaim("userName").asString());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(decodedJWT.getExpiresAt()));
    }

}
