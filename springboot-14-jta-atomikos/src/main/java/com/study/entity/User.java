package com.study.entity;

import lombok.Data;

/**
 * 
 * @描述: 用户信息数据库实体对象
 * @版权: Copyright (c) 2019 
 * @公司:  
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: Jun 17, 2019 
 * @创建时间: 3:15:14 PM
 */

@Data 
public class User {
    
    /**
        @Data 自动生成set/get方法，toString方法，equals方法，hashCode方法，不带参数的构造方法 
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