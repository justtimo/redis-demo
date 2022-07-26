package com.wby.redis.redisdemo;

import com.wby.redis.redisdemo.util.JedisPoolFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

class JedisTest {
    private Jedis jedis;
    @BeforeEach
    public void init(){
//        jedis = new Jedis("1.117.61.41", 6379);
        jedis = JedisPoolFactory.getJedis();
        jedis.select(1);
    }

    @Test
    void testString() {
        String set = jedis.set("name1111", "张三");
        System.out.println(set);
        String name1111 = jedis.get("name1111");
        System.out.println(name1111);
    }

    @AfterEach
    public void close() {
        if (jedis != null) {
            jedis.close();
        }
    }

}
