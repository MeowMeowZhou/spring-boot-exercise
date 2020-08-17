package com.zyj.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@Service
@Slf4j
public class ScheduleService {

//    @Scheduled(fixedDelay = 1000*5)
    public void print(){
        log.info("5 S 打印一次====>");
    }

}
