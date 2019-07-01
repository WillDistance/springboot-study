package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @描述: @SpringBootApplication 注解启动
 * @版权: Copyright (c) 2019 
 * @公司:  
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: Jun 13, 2019 
 * @创建时间: 11:22:01 PM
 */

@SpringBootApplication
public class AppStart2
{
    /**
     @SpringBootApplication 等同于@EnableAutoConfiguration+@ComponentScan
     @ComponentScan 默认会扫描该类所在的包下所有的配置类
     */
     public static void main(String[] args) {
        //启动整个springboot项目
        SpringApplication.run(AppStart2.class, args);
    }
}
