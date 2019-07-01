package com.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"com.study.test02.service.dao.*","com.study.test01.service.dao.*"}) 
@SpringBootApplication
public class AppStart
{
    /**
    @SpringBootApplication 等同于@EnableAutoConfiguration+@ComponentScan
    @ComponentScan 默认会扫描该类所在的包下所有的配置类
    */
    public static void main(String[] args) {
       //启动整个springboot项目
       SpringApplication.run(AppStart.class, args);
   }

}
