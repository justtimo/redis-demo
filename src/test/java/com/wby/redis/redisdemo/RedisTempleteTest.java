package com.wby.redis.redisdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class RedisTempleteTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void testString() {
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("age", 18);
        ops.set("name","wby");

        System.out.println(ops.get("age"));
        System.out.println(ops.get("name"));
    }


}
