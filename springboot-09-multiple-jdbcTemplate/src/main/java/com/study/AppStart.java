package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement //��ע���������
public class AppStart
{
    /**
    @SpringBootApplication ��ͬ��@EnableAutoConfiguration+@ComponentScan
    @ComponentScan Ĭ�ϻ�ɨ��������ڵİ������е�������
    
        �����������������JPA����JDBC�ȶ�ʵ���Խӿ� PlatformTransactionManager 
        �������ӵ��� spring-boot-starter-jdbc ��������ܻ�Ĭ��ע�� DataSourceTransactionManager ʵ����
        �������ӵ��� spring-boot-starter-data-jpa ��������ܻ�Ĭ��ע�� JpaTransactionManager ʵ����
    
    springboot Ĭ�Ͽ�����ע����������������������ϲ��� @EnableTransactionManagement Ҳ����ʹ�� @Transactional ��ʵ������
    
        ������Դʱ��Ҫ�ƶ�ʹ�� @Transactional(transactionManager = "primaryTransactionManager") ָ�����������
    */
    public static void main(String[] args) {
       //��������springboot��Ŀ
       SpringApplication.run(AppStart.class, args);
   }
    
    /*@Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager){
        System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
        return new Object();
    }*/

}
