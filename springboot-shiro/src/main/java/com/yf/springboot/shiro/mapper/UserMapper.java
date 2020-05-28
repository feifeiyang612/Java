package com.yf.springboot.shiro.mapper;

import com.yf.springboot.shiro.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: YangFei
 * @description:
 * @create:2020-05-28 11:11
 */

@Mapper
public interface UserMapper {

    public User findByName(String name);

    public User findById(Integer id);

}
