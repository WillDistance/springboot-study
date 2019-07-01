package com.study.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @����: springbootʹ��log4j��ӡ��־
 * @��Ȩ: Copyright (c) 2019 
 * @��˾:  
 * @����: ����
 * @�汾: 1.0 
 * @��������: Jun 16, 2019 
 * @����ʱ��: 10:18:07 AM
 */
@RestController
public class Log4jController
{
    //private static final Logger logger = Logger.getLogger(Log4jController.class);
    private static final Logger logger = LoggerFactory.getLogger(Log4jController.class);
    
    @RequestMapping("/log4jIndex")
    public String lo4jIndex() {
        logger.info("log4j��ӡ��־-info");
        logger.error("log4j��ӡ��־-error");
        return "ʹ��log4j��ӡ��־:"+this.getClass();
    }
    
    @RequestMapping("/lo4jAopIndex")
    public String lo4jAopIndex(String name,int age) {
        logger.info("log4j��ӡ��־-info");
        logger.error("log4j��ӡ��־-error");
        return "ʹ��log4j��ӡ��־:"+name+age;
    }
    
}
