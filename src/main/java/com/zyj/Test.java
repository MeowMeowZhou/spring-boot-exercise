package com.zyj;


import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        String url = "http://localhost:8080/receive/receive";
        HttpPost httpPost = new HttpPost(url);
        try {
            User user = new User("10010", "张三", 18, "男");
            System.out.println("user对象：=======>"+user);
            String jsonString = new ObjectMapper().writeValueAsString(user);
            System.out.println("json字符串：=======>"+jsonString);
            StringEntity stringEntity = new StringEntity(jsonString, "utf-8");
            httpPost.setEntity(stringEntity);
            httpPost.setHeader("Content-Type","application/json;charset=utf-8");
            CloseableHttpResponse response = httpClient.execute(httpPost);
            System.out.println("状态码：========>" + response.getStatusLine().getStatusCode());
            System.out.println("响应内容：========>" + EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
