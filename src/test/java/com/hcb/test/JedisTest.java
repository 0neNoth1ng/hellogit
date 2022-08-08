package com.hcb.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.Set;


/**
 * 使用Jedis操作redis
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class JedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedis() {
        //1.获取链接
        Jedis jedis = new Jedis("localhost", 6379);

        //2.执行具体的操作
        jedis.zadd("people", 0.1, "hcb");

        //3.关闭链接
        jedis.close();
    }

    @Test
    public void bootDataRedisForZSet() {
        redisTemplate.keys("*");

        ValueOperations valueOperations = redisTemplate.opsForValue();

        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add("people", "hcb", 0.5);
        zSetOperations.add("people", "zxy", 1.0);
        zSetOperations.add("people", "xrk", 1.5);
        Set people = zSetOperations.range("people", 0, -1);

        System.out.println(people);

    }

    @Test
    public void Hash() {
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put("people", "name", "hcb");
        hashOperations.put("people", "sex", "men");
        hashOperations.put("people", "age", "20");

        System.out.println(hashOperations.get("people", "name"));
        Set people = hashOperations.keys("people");
        for (Object key : people) {
            System.out.println(key);
        }


    }

    @Test
    public void Set() {
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.remove("people", "xrk", "hcb", "jll", "zxy");
    }

    /**
     * Redis的通用操作
     */
    @Test
    public void CommonRedis() {

        //获取所有的Key
        System.out.println(redisTemplate.keys("*"));


        //判断某个key是否存在
        Boolean aBoolean = redisTemplate.hasKey("people");
        System.out.println(aBoolean);

        //删除指定key
        redisTemplate.delete("people");

        //获取指定key的数据类型
        DataType type = redisTemplate.type("people");
        System.out.println(type);

        //获取所有的Key
        System.out.println(redisTemplate.keys("*"));
    }


}
