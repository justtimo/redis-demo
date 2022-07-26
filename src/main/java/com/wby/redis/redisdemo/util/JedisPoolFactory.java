package com.wby.redis.redisdemo.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolFactory {
    private static final JedisPool JEDIS_POOL;
    static {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(8);
        poolConfig.setMaxTotal(8);
        poolConfig.setMaxWaitMillis(1000);
        JEDIS_POOL = new JedisPool(poolConfig, "1.117.61.41", 6379, 1000);
    }

    public static Jedis getJedis() {
        return JEDIS_POOL.getResource();
    }
}
