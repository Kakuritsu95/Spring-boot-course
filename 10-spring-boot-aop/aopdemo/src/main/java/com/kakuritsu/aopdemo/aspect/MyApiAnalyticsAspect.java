package com.kakuritsu.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class MyApiAnalyticsAspect {

    @Before("com.kakuritsu.aopdemo.aspect.AspectUtils.forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("======> Performing API analytics Order#2");
    }
}
