package com.zyj;

import com.alibaba.fastjson.JSON;
import com.zyj.dao.ChargingStationMapper;
import com.zyj.entity.StationInfoEntity;
import com.zyj.service.ScheduleService;
import com.zyj.util.AES_CBC;
import com.zyj.util.HMacMD5;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringBootExerciseApplicationTests {

    @Resource
    private ScheduleService scheduleService;

    @Test
    void contextLoads() {
        scheduleService.print();
    }

}
