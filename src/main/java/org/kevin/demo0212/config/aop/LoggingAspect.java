package org.kevin.demo0212.config.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * aop 测试
 * @author Kevin.Z
 * @version 2020-03-19
 */
//@Aspect
//@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

//    @Around("execution(* org.kevin.demo0212.service.BlogUserService.*(..))")
//    @Around("execution(* org.kevin.demo0212.service..*(..))")
    public Object profileAllMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature = (MethodSignature)proceedingJoinPoint.getSignature();

        Map<String, Object> params = new HashMap<>();
        Object[] paraValues = proceedingJoinPoint.getArgs();
        String[] paraNames = methodSignature.getParameterNames();
        for (int i = 0; i < paraNames.length; i++) {
            params.put(paraNames[i], paraValues[i]);
            System.out.println(paraNames[i] + "_" + paraValues[i]);
        }

//        Object[] args = proceedingJoinPoint.getArgs();
//        String[] parameterNames = methodSignature.getParameterNames();
//
//        String username = (String)args[0];

        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        Object result = proceedingJoinPoint.proceed();

        LOGGER.info("the execution of methods from service." + className + ", and the method:" + methodName);

        return result;
    }
}
