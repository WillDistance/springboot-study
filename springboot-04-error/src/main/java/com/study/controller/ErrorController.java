package com.study.controller;

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
@RequestMapping(value="/ErrorController") 
public class ErrorController
{
    /**
              ��/error��Ϊurlӳ�䣬����������Ҳ��ӳ��·�� ����Ȼ������ʱ��ᱨ��˵ӳ���ַ�ظ� 
              ȫ�ֲ����쳣ʹ��AOP�����������쳣֪ͨ
     */
    @RequestMapping("/error")
    public String errorIndex(int i) {
        int j = 1/i;
        return "result:"+j;
    }
}
