package com.zyj;


import com.alibaba.fastjson.JSON;
import com.zyj.entity.User;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Date;

public class Test {

    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        String url = "http://localhost:8080/recive/recive";
        HttpPost httpPost = new HttpPost(url);
        User user = new User("10010", "张三", 18, "男", new Date());
        StringEntity stringEntity = new StringEntity(JSON.toJSONString(user), "utf-8");
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("send-msg","this is zyj send msg");
        httpPost.addHeader("send-msg-2","hahahahahha");
        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);
            System.out.println("响应行：========>" + response.getStatusLine());
            System.out.println("响应内容：========>" + EntityUtils.toString(response.getEntity()));
            System.out.println("响应头：========>"+response.getFirstHeader("msg-1"));
            System.out.println("响应头：========>"+response.getFirstHeader("msg-2"));
            System.out.println("响应头：========>"+response.getFirstHeader("msg-3"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
