package com.red;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class StringRedisTemplateTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Test
    void testStrGet(){
        //使用StringRedisTemplate
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        String name = ops.get("name");
        System.out.println(name);

        //或者指定RedisTemplate的泛型
        ValueOperations<String, String> ops1 = redisTemplate.opsForValue();
        String name1 = ops1.get("name");
        System.out.println(name1);

        System.out.println(name==name1);//false

    }
}
