package com.study.service;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @描述: 异步调用service
 * @版权: Copyright (c) 2019 
 * @公司:  
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: Jun 16, 2019 
 * @创建时间: 8:03:36 PM
 */

@Slf4j
@Service 
public class UserService
{
    /**
      @Service 将自动注册到Spring容器，不需要再在applicationContext.xml文件定义bean
               getBean的默认名称是类名（头字母小写），如果想自定义，可以@Service(“beanName”)这样来指定，
                              这种bean默认是单例的，如果想改变，可以使用@Service(“beanName”) @Scope(“prototype”)来改变。
                              
      @Async   标注的方法，称之为异步方法；这些方法将在执行的时候，将会在独立的线程中被执行，调用者无需等待它的完成，即可继续其他的操作。
     */
    
    /**
     * 
     * @描述：异步调用
     * @作者：严磊
     * @时间：Jun 16, 2019 7:52:34 PM
     * @return
     */
    @Async
    public String addUserSendEmalis(String name,String emalis) {
        log.info("3");
        try
        {
            Thread.sleep(5000);
            log.info("4");
            return "success- "+name+":"+emalis ;
        }
        catch (Exception e)
        {
            log.error("休眠异常",e);
        }
        return "error- "+name+":"+emalis ;
    }
    
    /**
     * 
     * @描述：异步调用 future 模式
     * @作者：严磊
     * @时间：Jun 16, 2019 8:55:30 PM
     * @param name
     * @param emalis
     * @return
     */
    @Async
    public Future<String> addUserSendEmalisFuture(String name,String emalis) {
        log.info("3");
        try
        {
            Thread.sleep(5000);
            log.info("4");
            return new AsyncResult<String>("success- "+name+":"+emalis); 
        }
        catch (Exception e)
        {
            log.error("休眠异常",e);
        }
        return new AsyncResult<String>("error- "+name+":"+emalis); 
    }
}
