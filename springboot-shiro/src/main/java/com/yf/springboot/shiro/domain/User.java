package com.yf.springboot.shiro.domain;

import lombok.Data;

/**
 * @author: YangFei
 * @description:
 * @create:2020-05-28 11:09
 */
@Data
public class User {

    private Integer id;
    private String name;
    private String password;
    private String perms;
}
