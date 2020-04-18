package com.timain.shiro.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体类
 * @author yyf
 * @version 1.0
 * @date 2020/4/17 20:52
 */
@Data
public class User implements Serializable {

    private String id;
    private String name;
    private String password;
}
