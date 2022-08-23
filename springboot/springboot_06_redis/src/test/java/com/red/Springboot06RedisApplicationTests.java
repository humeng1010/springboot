package com.red;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

@SpringBootTest
class Springboot06RedisApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void testSet(){
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("age",41);
    }

    @Test
    void testGet(){
        ValueOperations ops = redisTemplate.opsForValue();
        Object age = ops.get("age");
        System.out.println(age);
    }
    @Test
    void testHSet(){
        HashOperations ops = redisTemplate.opsForHash();
        ops.put("info","a","aa");
    }
    @Test
    void testHGet(){
        HashOperations ops = redisTemplate.opsForHash();
        Object age = ops.get("info","a");
        System.out.println(age);
    }

    @Test
    void contextLoads() {
    }

}
