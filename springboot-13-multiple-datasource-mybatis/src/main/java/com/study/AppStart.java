package com.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"com.study.test02.service.dao.*","com.study.test01.service.dao.*"}) 
@SpringBootApplication
public class AppStart
{
    /**
    @SpringBootApplication ��ͬ��@EnableAutoConfiguration+@ComponentScan
    @ComponentScan Ĭ�ϻ�ɨ��������ڵİ������е�������
    */
    public static void main(String[] args) {
       //��������springboot��Ŀ
       SpringApplication.run(AppStart.class, args);
   }

}
