package com.zyj.controller;

import com.zyj.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/recive")
public class HttpClientController {

    @PostMapping("/recive")
    public String recive(HttpServletResponse response, @RequestBody User user)  {
        System.out.println(user);
        response.setContentType("text/html;charset=UTF-8");
        response.addHeader("msg-1","-1");
        response.addHeader("msg-2", "我收到了信息-2");
        response.addHeader("msg-3","我收到了信息-3");
        return "收到。";
    }


}
