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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
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
@Aspect
@Component
public class WebLogAspect {
    
    /**
        timeAround - start
        timeAround - 1
        doBefore - start
        doBefore - end
        timeAround - 2
        timeAround - end
        doAfterReturning - start
        doAfterReturning - end
                ���� @Before ����ִ������ @Around �����е��� proceed() ִ��Ŀ�귽��֮ǰ ִ�� ��@AfterReturning ������������ִ��
    
        @Aspect:�����ǰѵ�ǰ���ʶΪһ�����湩������ȡ
        @Pointcut��Pointcut��ֲ��Advice�Ĵ���������ÿ��Pointcut�Ķ������2���֣�һ�Ǳ��ʽ�����Ƿ���ǩ��������ǩ�������� public��void�͡����Խ�Pointcut�еķ���������һ����Advice���õ����Ƿ�����Ϊ���ʽ��ֱ�ۣ�������ǿ���ͨ������ǩ���ķ�ʽΪ �˱��ʽ���������Pointcut�еķ���ֻ��Ҫ����ǩ����������Ҫ�ڷ������ڱ�дʵ�ʴ��롣
        @Around��������ǿ�������е�ִ��ǰ��ִ�к��൱��MethodInterceptor  
        @AfterReturning��������ǿ���൱��AfterReturningAdvice�����������˳�ʱִ��
        @Before����ʶһ��ǰ����ǿ�������൱��BeforeAdvice�Ĺ��ܣ����ƹ��ܵĻ���
        @AfterThrowing���쳣�׳���ǿ���൱��ThrowsAdvice
        @After: final��ǿ���������׳��쳣���������˳�����ִ��
            */
    //private static final Logger logger = Logger.getLogger(WebLogAspect.class);
    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
    
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
        System.out.println("doBefore - start");
        // ���յ����󣬼�¼��������
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // ��¼����������
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        Enumeration<String> enu = request.getParameterNames();
        Map<String,Object> param = new HashMap<String,Object>();
        while (enu.hasMoreElements()) {
            String name = (String) enu.nextElement();
            param.put(name, request.getParameter(name));
        }
        logger.info("��Σ�"+JSON.toJSONString(param));
        System.out.println("doBefore - end");
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
        System.out.println("doAfterReturning - start");
        // ���������󣬷�������
        logger.info("RESPONSE : " + ret);
        System.out.println("doAfterReturning - end");
        
    }
    
    /**
     * 
     * @������ͳ�Ʒ���ִ�к�ʱAround����֪ͨ �������е�ִ��ǰ��ִ�к� ������ʹ�� @Around ʵ��  @Before �� @AfterReturning �Ĺ���
     * @���ߣ�����
     * @ʱ�䣺Jun 17, 2019 9:57:00 AM
     * @param joinPoint
     * @return
     */
    @Around("webLog()")
    public Object timeAround(ProceedingJoinPoint joinPoint) {
        System.out.println("timeAround - start");
        //��ȡ��ʼִ�е�ʱ��
        long startTime = System.currentTimeMillis();
 
        // ���巵�ض��󡢵õ�������Ҫ�Ĳ���
        Object obj = null;
        
        //��ȡ������������Ĳ���
        Object[] args = joinPoint.getArgs();
        
        try {
            System.out.println("timeAround - 1");
            obj = joinPoint.proceed(args); //ִ��Ŀ�귽��
            System.out.println("timeAround - 2");
            //obj = joinPoint.proceed();
        } catch (Throwable e) {
            logger.error("ͳ��ĳ����ִ�к�ʱ����֪ͨ����", e);
        }
 
        // ��ȡִ�н�����ʱ��
        long endTime = System.currentTimeMillis();
        // ��ӡ��ʱ����Ϣ
        logger.info("���������󹲺�ʱ��{} ms",endTime-startTime);
        
        System.out.println("timeAround - end");
        return obj;
    }
}