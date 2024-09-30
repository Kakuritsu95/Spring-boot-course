package com.kakuritsu.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(3)
@Component
public class MyCloudLogAspect {

    @Before("com.kakuritsu.aopdemo.aspect.AspectUtils.forDaoPackageNoGetterSetter()")
    public void forDaoPackageNoGetterSetter(){
        System.out.println("======> Doing stuff in all dao methods EXCEPT getters and setters Order#3");
    }
}
