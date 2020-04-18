package com.timain.shiro.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色实体类
 * @author yyf
 * @version 1.0
 * @date 2020/4/17 21:05
 */
@Data
public class Role implements Serializable {

    private String id;
    private String name;
}
