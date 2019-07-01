package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.entity.User;
import com.study.service.UserService;

/**
 * 
 * @描述: 控制层
 * @版权: Copyright (c) 2019 
 * @公司:  
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: Jun 17, 2019 
 * @创建时间: 3:23:29 PM
 */
@RestController
@RequestMapping("/user")
public class JdbcController
{
    
    /**
       @Repository 、 @Service 、 @Controller 它们分别对应存储层(dao)Bean，业务层(service)Bean，和展示层(控制层controller)Bean。
       @Component 是一个泛化的概念，仅仅表示一个组件 (Bean) ，可以作用在任何层次
     */
    
    @Autowired
    UserService service;
    
    /**
     * 
     * @描述：查询用户信息
     * @作者：严磊
     * @时间：Jun 17, 2019 4:27:49 PM
     * @param id
     * @return
     */
    @RequestMapping("/query")
    public User queryUserController(int id)
    {
        return service.queryUser(id);
    }
    
    /**
     * 
     * @描述：保存用户信息
     * @作者：严磊
     * @时间：Jun 17, 2019 4:28:05 PM
     * @param user
     * @return
     */
    @RequestMapping("/save")
    public String saveUserController(User user)
    {
        return "save-result: "+ service.saveUser(user);
    }
    
}
