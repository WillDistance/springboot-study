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
    public static void main(String[] args)
    {
        //��������springboot��Ŀ  
        //http://127.0.0.1:8888/study/JspController/jspIndex
        SpringApplication.run(AppStart.class, args);
    }
}
