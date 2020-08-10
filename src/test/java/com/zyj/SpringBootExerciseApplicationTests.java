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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@SpringBootTest
class SpringBootExerciseApplicationTests {



    @Test
    void contextLoads() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String userName = "root";
            String passWord = "1234";
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_casmrc_test?serverTimezone=GMT%2B8",
                    userName,
                    passWord);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from tb_charging_station");
            while (resultSet.next()){
                System.out.println(resultSet.getString("id")+resultSet.getString("name"));
            }

            resultSet.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
