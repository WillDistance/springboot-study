package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
