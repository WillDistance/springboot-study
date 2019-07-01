package com.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.study.mapper") 
@SpringBootApplication
public class AppStart
{
    /**
     @SpringBootApplication ��ͬ��@EnableAutoConfiguration+@ComponentScan
     @ComponentScan Ĭ�ϻ�ɨ��������ڵİ������е�������
    
     mybatis������ʽ������mapper�㲻Ҫ��mapperע�⡣����һ��Ҫ���������ʱ����� @MapperScan
     myabtis��mybatis�ӿڼ��� @Mapper ע��myabtis�������Ͳ���Ҫ���������ʱ���� @MapperScan
    */
    public static void main(String[] args) {
       //��������springboot��Ŀ
       SpringApplication.run(AppStart.class, args);
   }

}
