package com.kakuritsu.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {
    private final Logger myLogger = Logger.getLogger(getClass().getName());

    @Before("com.kakuritsu.springboot.thymeleafdemo.aspect.AspectUtils.comboPointcut()")
    public void beforeLoggingAspect(JoinPoint joinPoint){
        myLogger.info("========>> in @Before: from method: " + joinPoint.getSignature().toShortString());
        for(Object arg: joinPoint.getArgs()){
            System.out.println(arg);
        }

    }
    @AfterReturning(pointcut = "com.kakuritsu.springboot.thymeleafdemo.aspect.AspectUtils.comboPointcut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        myLogger.info("========>> in @AfterReturning: from method: " + joinPoint.getSignature().toShortString());

        myLogger.info("======> " + result);

    }
}
