package com.zyj.conf.annotation.release;

import com.zyj.conf.annotation.PrintLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PrintLogAspect {

    @Pointcut("@annotation(com.zyj.conf.annotation.PrintLog)")
    public void controllerAspect(){}

//    @Before("controllerAspect()")
//    public void printBefore(){
//        System.out.println("这是前置通知");
//    }
//
//    @AfterReturning("controllerAspect()")
//    public void printAfterReturning(){
//        System.out.println("这是后置通知AfterReturning");
//    }
//
//    @After("controllerAspect()")
//    public void printAfter(){
//        System.out.println("这是后置通知After");
//    }

    @Around("controllerAspect()")
    public void printAround(ProceedingJoinPoint proceedingJoinPoint){
        try {
            System.out.println("这是前置通知。");
            Object[] args = proceedingJoinPoint.getArgs();
            for (Object obj : args){
                System.out.println(obj);
            }
            proceedingJoinPoint.proceed();
            System.out.println("这是后置通知。");
        } catch (Throwable throwable) {
            System.out.println("这是异常通知。");
            throwable.printStackTrace();
        } finally {
            System.out.println("这是最终通知。");
        }
    }

}
