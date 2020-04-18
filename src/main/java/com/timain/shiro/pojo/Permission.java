package com.timain.shiro.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 权限实体类
 * @author yyf
 * @version 1.0
 * @date 2020/4/17 21:06
 */
@Data
public class Permission implements Serializable {

    private String id;
    private String name;
    private String url;
}
