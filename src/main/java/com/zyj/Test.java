package com.zyj;

import com.alibaba.fastjson.JSON;
import com.zyj.entity.User;
import com.zyj.util.HMacMD5;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import java.util.Date;
import java.util.UUID;

@Slf4j
public class Test {

    public static void main(String[] args) {

        User user = new User("123","小明",2,"男",new Date(0));
        System.out.println(JSON.toJSONString(user));

    }

}
