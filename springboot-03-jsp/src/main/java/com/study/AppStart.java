package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppStart
{
    /**
    @SpringBootApplication 等同于@EnableAutoConfiguration+@ComponentScan
    @ComponentScan 默认会扫描该类所在的包下所有的配置类
    */
    public static void main(String[] args)
    {
        //启动整个springboot项目  
        //http://127.0.0.1:8888/study/JspController/jspIndex
        SpringApplication.run(AppStart.class, args);
    }
}
