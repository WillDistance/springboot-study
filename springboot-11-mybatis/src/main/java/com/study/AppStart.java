package com.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.study.dao") 
@SpringBootApplication
public class AppStart
{
    /**
    @SpringBootApplication 等同于@EnableAutoConfiguration+@ComponentScan
    @ComponentScan 默认会扫描该类所在的包下所有的配置类
    
        让mapper类被spring容器管理的两种方法：  
              1： @Mapper 在Mapper类上面添加注解 @Mapper，这种方式要求每一个mapper类都需要添加此注解
              2： @MapperScan 在启动类加上@MapperScan，可以指定要扫描的Mapper类的包的路径
              多个包： @MapperScan({"com.study.mapper1.*","com.study.mapper2.*"})、@MapperScan({"com.study.*.mapper","com.study.*.mapper"}) 
              单个包： @MapperScan("com.kfit.mapper") 
    */
    public static void main(String[] args) {
       //启动整个springboot项目
       SpringApplication.run(AppStart.class, args);
   }

}
