package com.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.study.dao") 
@SpringBootApplication
public class AppStart
{
    /**
    @SpringBootApplication ��ͬ��@EnableAutoConfiguration+@ComponentScan
    @ComponentScan Ĭ�ϻ�ɨ��������ڵİ������е�������
    
        ��mapper�౻spring������������ַ�����  
              1�� @Mapper ��Mapper���������ע�� @Mapper�����ַ�ʽҪ��ÿһ��mapper�඼��Ҫ��Ӵ�ע��
              2�� @MapperScan �����������@MapperScan������ָ��Ҫɨ���Mapper��İ���·��
              ������� @MapperScan({"com.study.mapper1.*","com.study.mapper2.*"})��@MapperScan({"com.study.*.mapper","com.study.*.mapper"}) 
              �������� @MapperScan("com.kfit.mapper") 
    */
    public static void main(String[] args) {
       //��������springboot��Ŀ
       SpringApplication.run(AppStart.class, args);
   }

}
