package com.study.error;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @描述: 全局捕获异常  1：捕获返回json格式  2：捕获返回页面
 * @版权: Copyright (c) 2019 
 * @公司:  
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: Jun 16, 2019 
 * @创建时间: 12:44:47 AM
 */

@Slf4j
@ControllerAdvice(basePackages = "com.study.controller")
public class GlobalExceprionHandler
{
    /**
     @ControllerAdvice 异常切入点
     
     @ResponseBody 返回json格式 
     modeAndView 返回页面
     
     @ExceptionHandler 捕获异常类型
    */
    
    /**
     * 
     * @描述：返回map对象
     * @作者：严磊
     * @时间：Jun 16, 2019 10:43:26 PM
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public Map<String,Object> errorResult(Exception e){
        Map<String,Object> errorResult =  new HashMap<String,Object>();
        errorResult.put("errorCode", "-1");
        errorResult.put("errorMsg", "系统异常");
        errorResult.put("error", e);
        log.error("全局异常捕获 - controller : ",e);
        return errorResult;
    }
    
    
    /**
     * 
     * @描述：返回视图页面
     * @作者：严磊
     * @时间：Jun 16, 2019 10:43:44 PM
     * @param e
     * @return
     */
    @ResponseBody
    //@ExceptionHandler(RuntimeException.class)
    public String errorResultView(Exception e){
        return "error/500";
    }
    
}
