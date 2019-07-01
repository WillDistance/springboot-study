package com.study.member.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @描述: springboot 第一个案例
 * @版权: Copyright (c) 2019 
 * @公司:  
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: Jun 12, 2019 
 * @创建时间: 11:30:06 PM
 */

@RestController
public class MemberController
{
    //@RestController注解 表示该类中所有方法返回json格式  等同于@Controller(加在类上) + @ResponseBody(加在方法上,方法返回json格式)
    //springboot启动原理:springMVC注解方式启动 内助HTTP服务器（默认是Tomcat）
    
    @RequestMapping("/memberIndex")
    public String memberIndex() {
        return "springboot 01 ";
    }
    
    
}
