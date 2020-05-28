package com.yf.springboot.shiro.service;

import com.yf.springboot.shiro.domain.User;
import com.yf.springboot.shiro.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: YangFei
 * @description:
 * @create:2020-05-28 11:13
 */

@Service
public class UserServiceImpl implements UserService {

    //注入Mapper接口
    @Resource
    private UserMapper userMapper;

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

}
