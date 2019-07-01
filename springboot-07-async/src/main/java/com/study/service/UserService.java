package com.study.service;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @����: �첽����service
 * @��Ȩ: Copyright (c) 2019 
 * @��˾:  
 * @����: ����
 * @�汾: 1.0 
 * @��������: Jun 16, 2019 
 * @����ʱ��: 8:03:36 PM
 */

@Slf4j
@Service 
public class UserService
{
    /**
      @Service ���Զ�ע�ᵽSpring����������Ҫ����applicationContext.xml�ļ�����bean
               getBean��Ĭ��������������ͷ��ĸСд����������Զ��壬����@Service(��beanName��)������ָ����
                              ����beanĬ���ǵ����ģ������ı䣬����ʹ��@Service(��beanName��) @Scope(��prototype��)���ı䡣
                              
      @Async   ��ע�ķ�������֮Ϊ�첽��������Щ��������ִ�е�ʱ�򣬽����ڶ������߳��б�ִ�У�����������ȴ�������ɣ����ɼ��������Ĳ�����
     */
    
    /**
     * 
     * @�������첽����
     * @���ߣ�����
     * @ʱ�䣺Jun 16, 2019 7:52:34 PM
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
            log.error("�����쳣",e);
        }
        return "error- "+name+":"+emalis ;
    }
    
    /**
     * 
     * @�������첽���� future ģʽ
     * @���ߣ�����
     * @ʱ�䣺Jun 16, 2019 8:55:30 PM
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
            log.error("�����쳣",e);
        }
        return new AsyncResult<String>("error- "+name+":"+emalis); 
    }
}
