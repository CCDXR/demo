package com.example.demo.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedisTest {

    private static StringRedisTemplate redisTemplate = new StringRedisTemplate();

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName("localhost");
        factory.setPort(6379);
        redisTemplate.setConnectionFactory(factory);
        redisTemplate.afterPropertiesSet();
    }


    public static void main(String[] args) throws JsonProcessingException {
        List<User> list = new ArrayList<>();
        User user1 = new User(1,"zhangsan", 20);
        User user2 = new User(2,"lisi", 23);
        User user3 = new User(3,"wangwu", 24);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        String listStr = objectMapper.writeValueAsString(list);
        redisTemplate.opsForValue().set("list", listStr);
        redisTemplate.opsForValue().set("test", "testfdaslj");

        String lstr = redisTemplate.opsForValue().get("list");
        System.out.println(lstr);
        List<User> l = objectMapper.readValue(lstr, new TypeReference<List<User>>(){});
        System.out.println(l.get(0).getName());

//        Map m = new HashMap<>();
//        m.put("id", 1);
//        m.put("name", "zhangym");
//        String json = objectMapper.writeValueAsString(m);
//        Map map = objectMapper.readValue(json, HashMap.class);
//        System.out.println(map.get("id") + String.valueOf(map.get("name")));


    }

}
