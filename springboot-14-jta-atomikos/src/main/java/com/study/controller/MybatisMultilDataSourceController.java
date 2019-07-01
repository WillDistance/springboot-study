package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.test01.service.UserServiceTest01;
import com.study.test02.service.UserServiceTest02;

/**
 * 
 * @描述: 多数据源测试 jta+atomikos
 * @版权: Copyright (c) 2019 
 * @公司:  
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: Jun 29, 2019 
 * @创建时间: 9:31:29 AM
 */
@RestController
public class MybatisMultilDataSourceController {
    @Autowired
    private UserServiceTest01 userServiceTest01;
    @Autowired
    private UserServiceTest02 userServiceTest02;

    @RequestMapping("/insertUserTest1")
    public Integer insertUserTest1(String name, Integer age,String email) {
        return userServiceTest01.insertUser(name, age,email);
    }

    @RequestMapping("/insertUserTest2")
    public Integer insertUserTest2(String name, Integer age,String email) {
        return userServiceTest02.insertUser(name, age,email);
    }

    @RequestMapping("/insertUserTest01AndTest02")
    public int insertUserTest01AndTest02(String name, Integer age,String email) {
        return userServiceTest02.insertUserTest01AndTest02(name, age,email);
    }
}
