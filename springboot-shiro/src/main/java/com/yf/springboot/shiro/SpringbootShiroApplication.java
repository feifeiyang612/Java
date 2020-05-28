package com.yf.springboot.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * SpringBoot启动类
 *
 * @author
 */
@SpringBootApplication
//之前是，直接在Mapper类上面添加注解@Mapper，这种方式要求每一个mapper类都需要添加此注解，麻烦
//通过使用@MapperScan可以指定要扫描的Mapper类的包的路径   同时,使用@MapperScan注解多个包
@MapperScan("com.yf.springboot.shiro.mapper")
public class SpringbootShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootShiroApplication.class, args);
    }

}
