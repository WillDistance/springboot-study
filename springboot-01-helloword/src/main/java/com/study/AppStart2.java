package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @����: @SpringBootApplication ע������
 * @��Ȩ: Copyright (c) 2019 
 * @��˾:  
 * @����: ����
 * @�汾: 1.0 
 * @��������: Jun 13, 2019 
 * @����ʱ��: 11:22:01 PM
 */

@SpringBootApplication
public class AppStart2
{
    /**
     @SpringBootApplication ��ͬ��@EnableAutoConfiguration+@ComponentScan
     @ComponentScan Ĭ�ϻ�ɨ��������ڵİ������е�������
     */
     public static void main(String[] args) {
        //��������springboot��Ŀ
        SpringApplication.run(AppStart2.class, args);
    }
}
