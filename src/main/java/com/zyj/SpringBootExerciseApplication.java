package com.zyj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.zyj.dao")
@EnableScheduling
public class SpringBootExerciseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExerciseApplication.class, args);
    }

}
