package com.zyj.controller;

import com.zyj.conf.annotation.PrintLog;
import com.zyj.service.Service1;
import com.zyj.service.Service2;
import com.zyj.service.sunservice.SubService;
import org.aspectj.lang.annotation.Around;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AspectTestController {

    @Resource
    private AspectTestController aspectTestController;

    @GetMapping("/go")
    public void go(){
        aspectTestController.test("hello?",23);
        System.out.println();
    }

    @PrintLog
    public String test(String str,int num){
        return "controller里面的测试方法";
    }

}
