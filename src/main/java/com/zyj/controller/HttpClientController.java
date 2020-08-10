package com.zyj.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zyj.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@RestController
@RequestMapping("/receive")
public class HttpClientController {

    @PostMapping("/receive")
    public String recive(HttpServletRequest request,HttpServletResponse response,@RequestBody String userStr) {

        System.out.println("请求体：=========>"+userStr);
        User parse = (User)JSONObject.parse("userStr");
        System.out.println("接受的对象：=========>"+parse);
        return "收到。";
    }


}
