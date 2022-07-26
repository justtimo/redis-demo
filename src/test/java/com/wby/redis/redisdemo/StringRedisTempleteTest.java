package com.wby.redis.redisdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wby.redis.redisdemo.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class StringRedisTempleteTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testString() {
        ValueOperations ops = stringRedisTemplate.opsForValue();
        ops.set("age1", "18");
        ops.set("name1","wby");

        System.out.println(ops.get("age1"));
        System.out.println(ops.get("name1"));
    }

    @Test
    void testObject() throws JsonProcessingException {
        User user = new User();
        user.setAge(11);
        user.setName("ww");
        stringRedisTemplate.opsForValue().set("user1", objectMapper.writeValueAsString(user));
        System.out.println(stringRedisTemplate.opsForValue().get("user1"));

        String user1 = stringRedisTemplate.opsForValue().get("user1");
        User user2 = objectMapper.readValue(user1, User.class);
        System.out.println(user2);
    }

}
