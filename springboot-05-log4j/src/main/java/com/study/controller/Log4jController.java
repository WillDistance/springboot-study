package com.study.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @描述: springboot使用log4j打印日志
 * @版权: Copyright (c) 2019 
 * @公司:  
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: Jun 16, 2019 
 * @创建时间: 10:18:07 AM
 */
@RestController
public class Log4jController
{
    //private static final Logger logger = Logger.getLogger(Log4jController.class);
    private static final Logger logger = LoggerFactory.getLogger(Log4jController.class);
    
    @RequestMapping("/log4jIndex")
    public String lo4jIndex() {
        logger.info("log4j打印日志-info");
        logger.error("log4j打印日志-error");
        return "使用log4j打印日志:"+this.getClass();
    }
    
    @RequestMapping("/lo4jAopIndex")
    public String lo4jAopIndex(String name,int age) {
        logger.info("log4j打印日志-info");
        logger.error("log4j打印日志-error");
        return "使用log4j打印日志:"+name+age;
    }
    
}
