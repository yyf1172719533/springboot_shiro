package com.timain.shiro.mapper;

import com.timain.shiro.pojo.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/17 22:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleMapperTest {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void queryRolesByUserId() {
        Set<Role> roles = roleMapper.queryRolesByUserId("1");
        roles.forEach(System.out::println);
    }
}