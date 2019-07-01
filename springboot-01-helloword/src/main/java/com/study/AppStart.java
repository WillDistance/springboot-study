package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @描述: 使用@EnableAutoConfiguration和 @ComponentScan 启动
 * @版权: Copyright (c) 2019 
 * @公司:  
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: Jun 13, 2019 
 * @创建时间: 10:51:48 PM
 */

@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.study.member.controller","com.study.order.controller"})
public class AppStart
{
    /**
       @EnableAutoConfiguration 注解的作用：它会根据pom.xml文件的依赖对spring进行自动配置  例如：由于pom文件中配置了spring-boot-starter-web添加了Tomcat和Spring MVC。它就会去配置Tomcat和springMVC
       @EnableAutoConfiguration 扫包范围：默认在当前类
             使用@ComponentScan添加扫包范围  默认会扫描该类所在的包下所有的配置类
             若扫描单个包用：@ComponentScan("com.study.member.controller")
             若扫描多个包用：@ComponentScan(basePackages = {"com.study.member.controller","com.study.order.controller"})
    */
    public static void main(String[] args) {
        //启动整个springboot项目
        SpringApplication.run(AppStart.class, args);
    }
}
