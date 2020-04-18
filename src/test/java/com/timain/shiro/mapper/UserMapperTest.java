package com.timain.shiro.mapper;

import com.timain.shiro.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/17 21:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void queryUserByUserName() {
        User user = userMapper.queryUserByUserName("vip");
        System.out.println(user);
    }
}