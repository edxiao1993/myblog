package org.kevin.demo0212.config.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.kevin.demo0212.config.annotations.AopLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Kevin.Z
 * @version 2020-04-20
 */
@Aspect
@Component
public class AopLogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(AopLogAspect.class);

    @Pointcut("@annotation(org.kevin.demo0212.config.annotations.AopLog)")
    public void aopLogCut(){}

    @Around("aopLogCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable{
        long beginTime = System.currentTimeMillis();
        Object result = point.proceed();
        LOGGER.info("this is the @aopLogCut. and the execution time is:" + (System.currentTimeMillis() - beginTime));

        MethodSignature ms = (MethodSignature) point.getSignature();
        Method method = ms.getMethod();
        AopLog aopLog = method.getAnnotation(AopLog.class);
        LOGGER.info("aop value:" + aopLog.value());


        return result;
    }
}
