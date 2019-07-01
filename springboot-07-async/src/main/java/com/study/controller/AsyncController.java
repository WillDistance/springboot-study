package com.study.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @描述: 通过@Async 注解实现方法的一部调用
 * @版权: Copyright (c) 2019 
 * @公司:  
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: Jun 16, 2019 
 * @创建时间: 4:46:48 PM
 */
@Slf4j
@RestController
@RequestMapping("/AsyncController")
public class AsyncController
{
    @Autowired
    private UserService service;
    
    /**
     * 
     * @描述：异步调用（调用的异步方法无返回值）
     * @作者：严磊
     * @时间：Jun 16, 2019 8:49:39 PM
     * @param name
     * @param emalis
     * @return
     */
    @RequestMapping("/asyncIndex")
    public String asyncIndex(String name,String emalis) {
        log.info("1");
        String result = service.addUserSendEmalis(name, emalis);
        log.info("2");
        return "send emalis Result :" + result;
    }
    
    
    /**
     * 
     * @描述：异步调用（使用future模式，调用的异步方法有返回值）
     * @作者：严磊
     * @时间：Jun 16, 2019 8:49:39 PM
     * @param name
     * @param emalis
     * @return
     */
    @RequestMapping("/asyncFutureIndex")
    public String asyncFutureIndex(String name, String emalis)
    {
        log.info("1");
        Future<String> resultFuture = service.addUserSendEmalisFuture(name, emalis);
        String result = "";
        //这里使用了循环判断，等待获取结果信息  
        while (true)
        {
            try
            {
                if ( resultFuture.isDone() ) //判断是否执行完毕  
                {
                    result = resultFuture.get();
                    break;
                }
                System.out.println("等待异步方法执行完毕... ");
                Thread.sleep(1000);
            }
            catch (InterruptedException | ExecutionException e)
            {
                log.error("等待异步方法返回出现异常", e);
            }
        }
        log.info("2");
        return "send emalis Result :" + result;
    }
}
