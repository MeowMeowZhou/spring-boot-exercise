package com.zyj.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Resource
    private JedisPool jedisPool;


    private Jedis init() {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jedis;
    }

    /*存入string类型并设置过期时间*/
    public void setKVTime(String key, String val, int expire, int database) {
        Jedis jedis = init();
        try {
            jedis.select(database);
            jedis.set(key, val);
            jedis.expire(key, expire);
        } catch (Exception e) {

        } finally {
            close(jedis);
        }
    }

    public void close(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

}
