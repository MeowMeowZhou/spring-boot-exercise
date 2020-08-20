package com.zyj.controller;

import com.zyj.util.RedisUtil;
import com.zyj.util.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.rmi.CORBA.Stub;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class TestController {

    @Resource
    private RedisUtil redisUtil;


    @PostMapping("/stu")
    public void stu(@RequestBody Student student){
        System.out.println(student);
    }

    @GetMapping("/{k}/{v}")
    public void test(@PathVariable String k,@PathVariable String v){
        redisUtil.setKVTime(k,v,60,11);
    }

    @GetMapping("/listener")
    public Object lisener(HttpServletRequest request){
        Object userNum = request.getSession().getAttribute("userNum");
        return "用户数："+userNum;

    }

    @GetMapping("/test/test")
    public Object test(HttpServletRequest request){
        Object userNum = request.getSession().getAttribute("userNum");
        return userNum;
    }

}
