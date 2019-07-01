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
 * @����: ͨ��@Async ע��ʵ�ַ�����һ������
 * @��Ȩ: Copyright (c) 2019 
 * @��˾:  
 * @����: ����
 * @�汾: 1.0 
 * @��������: Jun 16, 2019 
 * @����ʱ��: 4:46:48 PM
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
     * @�������첽���ã����õ��첽�����޷���ֵ��
     * @���ߣ�����
     * @ʱ�䣺Jun 16, 2019 8:49:39 PM
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
     * @�������첽���ã�ʹ��futureģʽ�����õ��첽�����з���ֵ��
     * @���ߣ�����
     * @ʱ�䣺Jun 16, 2019 8:49:39 PM
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
        //����ʹ����ѭ���жϣ��ȴ���ȡ�����Ϣ  
        while (true)
        {
            try
            {
                if ( resultFuture.isDone() ) //�ж��Ƿ�ִ�����  
                {
                    result = resultFuture.get();
                    break;
                }
                System.out.println("�ȴ��첽����ִ�����... ");
                Thread.sleep(1000);
            }
            catch (InterruptedException | ExecutionException e)
            {
                log.error("�ȴ��첽�������س����쳣", e);
            }
        }
        log.info("2");
        return "send emalis Result :" + result;
    }
}
