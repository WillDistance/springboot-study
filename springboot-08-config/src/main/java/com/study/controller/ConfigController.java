package com.study.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @����: ȫ�ֲ����쳣 controller
 * @��Ȩ: Copyright (c) 2019 
 * @��˾:  
 * @����: ����
 * @�汾: 1.0 
 * @��������: Jun 16, 2019 
 * @����ʱ��: 12:41:18 AM
 */

@RestController
@RequestMapping(value="/ConfigController") 
public class ConfigController
{
    /**
              ���� spring.profiles.active=dev ��ֵȡ��ͬ�����µ������ļ�
       dev:���ؿ�������
       test:���Ի���
       prd:��������
     */
    @Value("${http_url}")
    private String configUrl;
    
    @RequestMapping("/config")
    public String configIndex() {
        return "config-url: "+configUrl;
    }
}
