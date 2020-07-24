package com.zyj.conf;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AspectConf {

    @Pointcut("execution(* com.zyj.service..*.*(..))")
    public void printLogAspect(){}

    @Before("printLogAspect()")
    public void print(){
        System.out.println("前置通知");

    }




}
