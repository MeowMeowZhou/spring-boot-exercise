package com.zyj.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zyj.util.AES_CBC;
import com.zyj.util.HMacMD5;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.UUID;

@RestController
public class ConnectorStatusController {

    /*模拟接受充电设备接口状态变化的推送信息*/
    @PostMapping("/notification_stationStatus")
    public String notificationStationStatus(HttpServletRequest request, @RequestBody String paramEntity) {
        System.out.println("============充电设备接口状态变化的推送信息=============");
        System.out.println("头部验证信息，Authorization："+request.getHeader("Authorization"));
        System.out.println("请求体："+paramEntity);
        JSONObject jsonObject = JSON.parseObject(paramEntity);
        jsonObject.forEach((k, v) -> {
            if (k.equals("Data")) {
                System.out.println(k+":"+ AES_CBC.decrypt(v.toString(),"oAP26X8hrEbf2ntW".getBytes(),"g0HfLRfvM0VynlWa".getBytes()));
            } else {
                System.out.println(k + ":" + v);
            }
        });
        System.out.println("我们生成的签名：===>"+jsonObject.getString("Sig"));

        JSONObject backDataEntity = new JSONObject();
        backDataEntity.put("Status",0);
        String data = AES_CBC.encrypt(JSON.toJSONString(backDataEntity), "oAP26X8hrEbf2ntW".getBytes(), "g0HfLRfvM0VynlWa".getBytes());

        JSONObject backEntity = new JSONObject();
        backEntity.put("Data",data);
        backEntity.put("Ret",0);
        backEntity.put("Msg","notification connector status success!");
        String sig = HMacMD5.getHmacMd5Str("JACXjKRjemF0YwV2", 0 + "notification connector status success!" + data);
        backEntity.put("Sig",sig);
        String jsonString = JSON.toJSONString(backEntity);
        System.out.println("充电设备接口状态变化返回值=======>"+jsonString+"\n");
        return jsonString;
    }

    /*模拟Token请求*/
    @PostMapping("/query_token")
    public String queryToken(HttpServletRequest request,@RequestBody String paramEntity){
        System.out.println("==============获取token请求的信息================");
        System.out.println("请求体：==>"+paramEntity);
        JSONObject jsonObject = JSON.parseObject(paramEntity);
        jsonObject.forEach((k, v) -> {
            if (k.equals("Data")) {
                System.out.println(k+":"+ AES_CBC.decrypt(v.toString(),"oAP26X8hrEbf2ntW".getBytes(),"g0HfLRfvM0VynlWa".getBytes()));
            } else {
                System.out.println(k + ":" + v);
            }
        });
        String nativeSig = HMacMD5.getHmacMd5Str("",
                  jsonObject.get("OperatorID").toString() +
                        jsonObject.get("Data").toString() +
                        jsonObject.get("TimeStamp").toString() +
                        jsonObject.get("Seq").toString());
        System.out.println("我们生成的签名：===>"+jsonObject.getString("Sig"));

        JSONObject tokenEntity = new JSONObject();
        tokenEntity.put("OperatorID","MA6NNDH83");
        tokenEntity.put("SuccStat",0);
        tokenEntity.put("AccessToken", UUID.randomUUID().toString().replace("-",""));
        tokenEntity.put("TokenAvailableTime ",7200);
        tokenEntity.put("FailReason ",0);
        String data = AES_CBC.encrypt(JSON.toJSONString(tokenEntity), "oAP26X8hrEbf2ntW".getBytes(), "g0HfLRfvM0VynlWa".getBytes());

        JSONObject backEntity = new JSONObject();
        backEntity.put("Data",data);
        backEntity.put("Ret",0);
        backEntity.put("Msg","get token success!");
        String sig = HMacMD5.getHmacMd5Str("JACXjKRjemF0YwV2", 0 + "get token success!" + data);
        backEntity.put("Sig",sig);
        String jsonString = JSON.toJSONString(backEntity);
        System.out.println("Token返回值=======>"+jsonString+"\n");
        return jsonString;
    }


}
