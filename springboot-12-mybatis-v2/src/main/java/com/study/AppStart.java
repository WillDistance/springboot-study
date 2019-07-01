package com.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.study.mapper") 
@SpringBootApplication
public class AppStart
{
    /**
     @SpringBootApplication 等同于@EnableAutoConfiguration+@ComponentScan
     @ComponentScan 默认会扫描该类所在的包下所有的配置类
    
     mybatis启动方式可以在mapper层不要加mapper注解。但是一定要在启动类的时候加上 @MapperScan
     myabtis在mybatis接口加上 @Mapper 注入myabtis容器，就不需要在启动类的时加上 @MapperScan
    */
    public static void main(String[] args) {
       //启动整个springboot项目
       SpringApplication.run(AppStart.class, args);
   }

}
