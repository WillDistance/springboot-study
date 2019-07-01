package com.study.log;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
}