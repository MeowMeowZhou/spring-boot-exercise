package com.zyj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zyj.dao")
public class SpringBootExerciseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExerciseApplication.class, args);
    }

}
