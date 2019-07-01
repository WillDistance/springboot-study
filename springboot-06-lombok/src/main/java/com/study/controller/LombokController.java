package com.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.study.entity.User;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @描述: lombok 插件使用
 * @版权: Copyright (c) 2019 
 * @公司:  
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: Jun 16, 2019 
 * @创建时间: 4:46:48 PM
 */
@Slf4j
@RestController
@RequestMapping("/LombokController")
public class LombokController
{
    @RequestMapping("/lombokIndex")
    public String lombokIndex(String name,int age) {
        log.info("使用Lombok插件简化代码");
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return "使用Lombok插件简化代码："+user.toString();
    }
}
