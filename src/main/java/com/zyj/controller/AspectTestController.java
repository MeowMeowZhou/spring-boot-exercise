package com.zyj.controller;

import com.zyj.service.Service1;
import com.zyj.service.Service2;
import com.zyj.service.sunservice.SubService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/aspect")
public class AspectTestController {

    @Resource
    private Service1 service1;

    @Resource
    private Service2 service2;

    @Resource
    private SubService subService;

    @RequestMapping("/test")
    public void test(){
        new Service1();
        service1.funA();
        service1.funB();
        service2.fun1();
        service2.fun2();
        subService.fun1();

    }

}
