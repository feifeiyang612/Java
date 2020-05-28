package com.yf.springboot.shiro.service;

import com.yf.springboot.shiro.domain.User;

/**
 * @author: YangFei
 * @description:
 * @create:2020-05-28 11:12
 */
public interface UserService {

    public User findByName(String name);

    public User findById(Integer id);
}
