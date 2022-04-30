package com.internet.jiaowuxitong.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//知道.xml文件位置，扫描到mapper接口,不然会报错找不到依赖org.springframework.beans.factory.UnsatisfiedDependencyException
@MapperScan("com.internet.jiaowuxitong.mapper")
public class LoginConfiguration {
}
