package com.study.entity;

import lombok.Data;

/**
 * 
 * @����: �û���Ϣ���ݿ�ʵ�����
 * @��Ȩ: Copyright (c) 2019 
 * @��˾:  
 * @����: ����
 * @�汾: 1.0 
 * @��������: Jun 17, 2019 
 * @����ʱ��: 3:15:14 PM
 */

@Data 
public class User {
    
    /**
        @Data �Զ�����set/get������toString������equals������hashCode���������������Ĺ��췽�� 
     */
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    
    public static void main(String[] args)
    {
        System.out.println(1/0);
    }
}