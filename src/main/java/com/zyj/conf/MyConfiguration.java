package com.zyj.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class MyConfiguration {

    @Bean
    public JedisPool jedisPool() {
        /*JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(100);
        poolConfig.setMaxTotal(100);
        poolConfig.setMaxWaitMillis(600 * 1000);
        JedisPool jedisPool = new JedisPool(poolConfig, constant.getRedisHost(), constant.getRedisPort(),
                600 * 1000, constant.getRedisPwd());*/
        return new JedisPool("localhost",6379);
    }

}
