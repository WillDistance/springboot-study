package com.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.entity.User;
import com.study.test01.service.UserService1;
import com.study.test02.service.UserService2;

/**
 * 
 * @描述: 使用分包的方式使用多数据源
 * @版权: Copyright (c) 2019 
 * @公司:  
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: Jun 17, 2019 
 * @创建时间: 3:23:29 PM
 */
@RestController
@RequestMapping("/user")
public class MultipleDatasourceController
{
    
    /**
       @Repository 、 @Service 、 @Controller 它们分别对应存储层(dao)Bean，业务层(service)Bean，和展示层(控制层controller)Bean。
       @Component 是一个泛化的概念，仅仅表示一个组件 (Bean) ，可以作用在任何层次
     */
    
    @Autowired
    @Qualifier("UserServiceImpl1")
    UserService1 service1;
    
    @Autowired
    @Qualifier("UserServiceImpl2")
    UserService2 service2;
    
    /**
     * 
     * @描述：保存用户信息
     * @作者：严磊
     * @时间：Jun 17, 2019 4:28:05 PM
     * @param user
     * @return
     */
    @RequestMapping("/save1")
    public String saveUserController1(User user)
    {
        return "save-result: "+ service1.saveUser(user);
    }
    
    
    /**
     * 
     * @描述：保存用户信息
     * @作者：严磊
     * @时间：Jun 17, 2019 4:28:05 PM
     * @param user
     * @return
     */
    @RequestMapping("/save2")
    public String saveUserController2(User user)
    {
        return "save-result: "+ service2.saveUser(user);
    }
}
