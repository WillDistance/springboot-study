package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync 
public class AppStart
{
    /**
    @SpringBootApplication ��ͬ��@EnableAutoConfiguration+@ComponentScan
    @ComponentScan Ĭ�ϻ�ɨ��������ڵİ������е�������
    
    @EnableAsync ��������ɨ�跽�����첽���ã����� @Async ע�ⲻ������
    */
    public static void main(String[] args) {
       //��������springboot��Ŀ
       SpringApplication.run(AppStart.class, args);
   }

}
