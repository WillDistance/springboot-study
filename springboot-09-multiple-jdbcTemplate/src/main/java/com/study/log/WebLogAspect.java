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
 * @����: ʹ��aop����ͬ��web������־  
  *                 ʹ��slf4j����ӡ��־����־�ļ� ����Ϊspring-boot-starter-web���Դ���logback��������SLF4Jֻ�ܰ�һ��Ψһ����־��ܣ�
  *                 ��Ҫ��pom �ļ����ų�logback��Ӱ��
 * @��Ȩ: Copyright (c) 2019 
 * @��˾:  
 * @����: ����
 * @�汾: 1.0 
 * @��������: Jun 16, 2019 
 * @����ʱ��: 4:41:55 PM
 */
@Slf4j
@Aspect
@Component
public class WebLogAspect {
    
    /**
            ���� @Before ����ִ������ @Around �����е��� proceed() ִ��Ŀ�귽��֮ǰ ִ�� ��@AfterReturning ������������ִ��
    */
    
    /**
            �����е�Pointcut
            ��һ��*�ţ���ʾ�������ͣ� *�ű�ʾ���е�����
            �ڶ���*�ţ���ʾ������*�ű�ʾ���е���
            ������*�ţ���ʾ��������*�ű�ʾ���еķ���
            �������������ʾ�����Ĳ�������������ʾ�κβ���
     */
    @Pointcut("execution(public * com.study.controller.*.*(..))")
    public void webLog() {
    }

    /**
     * 
     * @����������ǰ��֪ͨ����ӡ������Ϣ
     * @���ߣ�����
     * @ʱ�䣺Jun 16, 2019 12:41:57 PM
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // ���յ����󣬼�¼��������
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // ��¼����������
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        Enumeration<String> enu = request.getParameterNames();
        Map<String,Object> param = new HashMap<String,Object>();
        while (enu.hasMoreElements()) {
            String name = (String) enu.nextElement();
            param.put(name, request.getParameter(name));
        }
        log.info("��Σ�"+JSON.toJSONString(param));
    }

    /**
     * 
     * @�������������֪ͨ����ӡ������
     * @���ߣ�����
     * @ʱ�䣺Jun 16, 2019 12:42:38 PM
     * @param ret
     * @throws Throwable
     */
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // ���������󣬷�������
        log.info("RESPONSE : " + ret);
    }
    
    /**
     * 
     * @������ͳ�Ʒ���ִ�к�ʱAround����֪ͨ ������ʹ�� @Around ʵ��  @Before �� @AfterReturning �Ĺ���
     * @���ߣ�����
     * @ʱ�䣺Jun 17, 2019 9:57:00 AM
     * @param joinPoint
     * @return
     */
    @Around("webLog()")
    public Object timeAround(ProceedingJoinPoint joinPoint)
    {
        //��ȡ��ʼִ�е�ʱ��
        long startTime = System.currentTimeMillis();
        // ���巵�ض��󡢵õ�������Ҫ�Ĳ���
        Object obj = null;
        
        //��ȡ������������Ĳ���
        Object[] args = joinPoint.getArgs();
        
        try
        {
            obj = joinPoint.proceed(args); //ִ��Ŀ�귽��
        }
        catch (Throwable e)
        {
            log.error("ͳ�Ʒ���ִ�к�ʱ����֪ͨ����", e);
        }
        // ��ȡִ�н�����ʱ��
        long endTime = System.currentTimeMillis();
        // ��ӡ��ʱ����Ϣ
        log.info("���������󹲺�ʱ��{} ms", endTime - startTime);
        return obj;
    }
}