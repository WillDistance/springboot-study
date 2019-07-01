package com.study.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @描述: 全局捕获异常 controller
 * @版权: Copyright (c) 2019 
 * @公司:  
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: Jun 16, 2019 
 * @创建时间: 12:41:18 AM
 */

@RestController
@RequestMapping(value="/ConfigController") 
public class ConfigController
{
    /**
              根据 spring.profiles.active=dev 的值取不同环境下的配置文件
       dev:本地开发环境
       test:测试环境
       prd:生产环境
     */
    @Value("${http_url}")
    private String configUrl;
    
    @RequestMapping("/config")
    public String configIndex() {
        return "config-url: "+configUrl;
    }
}
