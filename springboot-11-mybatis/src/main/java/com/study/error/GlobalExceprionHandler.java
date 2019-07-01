package com.study.error;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @����: ȫ�ֲ����쳣  1�����񷵻�json��ʽ  2�����񷵻�ҳ��
 * @��Ȩ: Copyright (c) 2019 
 * @��˾:  
 * @����: ����
 * @�汾: 1.0 
 * @��������: Jun 16, 2019 
 * @����ʱ��: 12:44:47 AM
 */

@Slf4j
@ControllerAdvice(basePackages = "com.study.controller")
public class GlobalExceprionHandler
{
    /**
     @ControllerAdvice �쳣�����
     
     @ResponseBody ����json��ʽ 
     modeAndView ����ҳ��
     
     @ExceptionHandler �����쳣����
    */
    
    /**
     * 
     * @����������map����
     * @���ߣ�����
     * @ʱ�䣺Jun 16, 2019 10:43:26 PM
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public Map<String,Object> errorResult(Exception e){
        Map<String,Object> errorResult =  new HashMap<String,Object>();
        errorResult.put("errorCode", "-1");
        errorResult.put("errorMsg", "ϵͳ�쳣");
        errorResult.put("error", e);
        log.error("ȫ���쳣���� - controller : ",e);
        return errorResult;
    }
    
    
    /**
     * 
     * @������������ͼҳ��
     * @���ߣ�����
     * @ʱ�䣺Jun 16, 2019 10:43:44 PM
     * @param e
     * @return
     */
    @ResponseBody
    //@ExceptionHandler(RuntimeException.class)
    public String errorResultView(Exception e){
        return "error/500";
    }
    
}
