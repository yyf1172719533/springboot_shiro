package com.timain.shiro.mapper;

import com.timain.shiro.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/17 21:13
 */
@Repository
public interface UserMapper {

    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    User queryUserByUserName(String userName);
}
