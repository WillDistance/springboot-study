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
                表明 @Before 方法执行是在 @Around 方法中调用 proceed() 执行目标方法之前 执行 ，@AfterReturning 方法是在最后才执行
    
        @Aspect:作用是把当前类标识为一个切面供容器读取
        @Pointcut：Pointcut是植入Advice的触发条件。每个Pointcut的定义包括2部分，一是表达式，二是方法签名。方法签名必须是 public及void型。可以将Pointcut中的方法看作是一个被Advice引用的助记符，因为表达式不直观，因此我们可以通过方法签名的方式为 此表达式命名。因此Pointcut中的方法只需要方法签名，而不需要在方法体内编写实际代码。
        @Around：环绕增强，控制切点执行前，执行后。相当于MethodInterceptor  
        @AfterReturning：后置增强，相当于AfterReturningAdvice，方法正常退出时执行
        @Before：标识一个前置增强方法，相当于BeforeAdvice的功能，相似功能的还有
        @AfterThrowing：异常抛出增强，相当于ThrowsAdvice
        @After: final增强，不管是抛出异常或者正常退出都会执行
            */
    //private static final Logger logger = Logger.getLogger(WebLogAspect.class);
    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
    
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
        System.out.println("doBefore - start");
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        Enumeration<String> enu = request.getParameterNames();
        Map<String,Object> param = new HashMap<String,Object>();
        while (enu.hasMoreElements()) {
            String name = (String) enu.nextElement();
            param.put(name, request.getParameter(name));
        }
        logger.info("入参："+JSON.toJSONString(param));
        System.out.println("doBefore - end");
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
        System.out.println("doAfterReturning - start");
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
        System.out.println("doAfterReturning - end");
        
    }
    
    /**
     * 
     * @描述：统计方法执行耗时Around环绕通知 ，控制切点执行前，执行后 。可以使用 @Around 实现  @Before 和 @AfterReturning 的功能
     * @作者：严磊
     * @时间：Jun 17, 2019 9:57:00 AM
     * @param joinPoint
     * @return
     */
    @Around("webLog()")
    public Object timeAround(ProceedingJoinPoint joinPoint) {
        System.out.println("timeAround - start");
        //获取开始执行的时间
        long startTime = System.currentTimeMillis();
 
        // 定义返回对象、得到方法需要的参数
        Object obj = null;
        
        //获取请求这个方法的参数
        Object[] args = joinPoint.getArgs();
        
        try {
            System.out.println("timeAround - 1");
            obj = joinPoint.proceed(args); //执行目标方法
            System.out.println("timeAround - 2");
            //obj = joinPoint.proceed();
        } catch (Throwable e) {
            logger.error("统计某方法执行耗时环绕通知出错", e);
        }
 
        // 获取执行结束的时间
        long endTime = System.currentTimeMillis();
        // 打印耗时的信息
        logger.info("处理本次请求共耗时：{} ms",endTime-startTime);
        
        System.out.println("timeAround - end");
        return obj;
    }
}