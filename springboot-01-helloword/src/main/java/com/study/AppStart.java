package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @����: ʹ��@EnableAutoConfiguration�� @ComponentScan ����
 * @��Ȩ: Copyright (c) 2019 
 * @��˾:  
 * @����: ����
 * @�汾: 1.0 
 * @��������: Jun 13, 2019 
 * @����ʱ��: 10:51:48 PM
 */

@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.study.member.controller","com.study.order.controller"})
public class AppStart
{
    /**
       @EnableAutoConfiguration ע������ã��������pom.xml�ļ���������spring�����Զ�����  ���磺����pom�ļ���������spring-boot-starter-web�����Tomcat��Spring MVC�����ͻ�ȥ����Tomcat��springMVC
       @EnableAutoConfiguration ɨ����Χ��Ĭ���ڵ�ǰ��
             ʹ��@ComponentScan���ɨ����Χ  Ĭ�ϻ�ɨ��������ڵİ������е�������
             ��ɨ�赥�����ã�@ComponentScan("com.study.member.controller")
             ��ɨ�������ã�@ComponentScan(basePackages = {"com.study.member.controller","com.study.order.controller"})
    */
    public static void main(String[] args) {
        //��������springboot��Ŀ
        SpringApplication.run(AppStart.class, args);
    }
}
