package com.study.log;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @描述: 使用aop处理同意web请求日志  
  *                 使用slf4j不打印日志到日志文件 是因为spring-boot-starter-web中自带的logback依赖，而SLF4J只能绑定一个唯一的日志框架，
  *                 需要在pom 文件中排除logback的影响
 * @版权: Copyright (c) 2019 
 * @公司:  
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: Jun 16, 2019 
 * @创建时间: 4:41:55 PM
 */
@Slf4j
@Aspect
@Component
public class WebLogAspect {
    
    /**
            表明 @Before 方法执行是在 @Around 方法中调用 proceed() 执行目标方法之前 执行 ，@AfterReturning 方法是在最后才执行
    */
    
    /**
            定义切点Pointcut
            第一个*号：表示返回类型， *号表示所有的类型
            第二个*号：表示类名，*号表示所有的类
            第三个*号：表示方法名，*号表示所有的方法
            后面括弧里面表示方法的参数，两个句点表示任何参数
     */
    @Pointcut("execution(public * com.study.controller.*.*(..))")
    public void webLog() {
    }

    /**
     * 
     * @描述：请求前置通知，打印请求信息
     * @作者：严磊
     * @时间：Jun 16, 2019 12:41:57 PM
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        Enumeration<String> enu = request.getParameterNames();
        Map<String,Object> param = new HashMap<String,Object>();
        while (enu.hasMoreElements()) {
            String name = (String) enu.nextElement();
            param.put(name, request.getParameter(name));
        }
        log.info("入参："+JSON.toJSONString(param));
    }

    /**
     * 
     * @描述：请求后置通知，打印请求结果
     * @作者：严磊
     * @时间：Jun 16, 2019 12:42:38 PM
     * @param ret
     * @throws Throwable
     */
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("RESPONSE : " + ret);
    }
    
    /**
     * 
     * @描述：统计方法执行耗时Around环绕通知 ，可以使用 @Around 实现  @Before 和 @AfterReturning 的功能
     * @作者：严磊
     * @时间：Jun 17, 2019 9:57:00 AM
     * @param joinPoint
     * @return
     */
    @Around("webLog()")
    public Object timeAround(ProceedingJoinPoint joinPoint)
    {
        //获取开始执行的时间
        long startTime = System.currentTimeMillis();
        // 定义返回对象、得到方法需要的参数
        Object obj = null;
        
        //获取请求这个方法的参数
        Object[] args = joinPoint.getArgs();
        
        try
        {
            obj = joinPoint.proceed(args); //执行目标方法
        }
        catch (Throwable e)
        {
            log.error("统计方法执行耗时环绕通知出错", e);
        }
        // 获取执行结束的时间
        long endTime = System.currentTimeMillis();
        // 打印耗时的信息
        log.info("处理本次请求共耗时：{} ms", endTime - startTime);
        return obj;
    }
}