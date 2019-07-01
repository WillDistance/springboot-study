package com.study.controller;

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
@RequestMapping(value="/ErrorController") 
public class ErrorController
{
    /**
              以/error作为url映射，必须在类上也加映射路径 ，不然启动的时候会报错，说映射地址重复 
              全局捕获异常使用AOP技术，采用异常通知
     */
    @RequestMapping("/error")
    public String errorIndex(int i) {
        int j = 1/i;
        return "result:"+j;
    }
}
