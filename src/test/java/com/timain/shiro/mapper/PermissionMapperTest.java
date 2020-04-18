package com.timain.shiro.mapper;

import com.timain.shiro.pojo.Permission;
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
 * @date 2020/4/17 22:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionMapperTest {

    @Autowired
    private PermissionMapper permissionMapper;

    @Test
    public void queryPermissionByUserId() {
        Set<Permission> permissionSet = permissionMapper.queryPermissionByUserId("1");
        permissionSet.forEach(System.out::println);
    }
}