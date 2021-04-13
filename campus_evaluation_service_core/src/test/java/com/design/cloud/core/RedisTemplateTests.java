package com.design.cloud.core;

import com.design.cloud.core.entity.User;
import com.design.cloud.core.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author ezuy
 * @date 21/4/10 18:03
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTemplateTests {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private UserMapper userMapper;

    @Test
    public void saveUser() {
        User user = userMapper.selectById(1);
        redisTemplate.opsForValue().set("user", user, 5, TimeUnit.MINUTES);
    }

    @Test
    public void getUser(){
        User user = (User) redisTemplate.opsForValue().get("user");
        System.out.println(user);
    }
}
