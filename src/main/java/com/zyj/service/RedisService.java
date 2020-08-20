package com.zyj.service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisService {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("localhost", 6379);
        jedis.auth("1234");
        jedis.select(1);
        jedis.hset("lasttime:connector:status:2004030001", "1", "0");
        jedis.hset("lasttime:connector:status:2004030001", "2", "0");
        jedis.hset("lasttime:connector:status:2004030002", "1", "1");
        jedis.hset("lasttime:connector:status:2004030002", "2", "0");
        jedis.hset("lasttime:connector:status:2004030003", "1", "1");
        jedis.hset("lasttime:connector:status:2004030004", "2", "1");



    }


}
