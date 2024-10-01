package com.kakuritsu.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AspectUtils {

    @Pointcut("execution(* com.kakuritsu.springboot.thymeleafdemo.controller.*.*(..))")
    public void controllerFolderPointcut(){}
    @Pointcut("execution(* com.kakuritsu.springboot.thymeleafdemo.dao.*.*(..))")
    public void daoFolderPointcut(){}
    @Pointcut("execution(* com.kakuritsu.springboot.thymeleafdemo.service.*.*(..))")
    public void serviceFolderPointcut(){}

    @Pointcut("controllerFolderPointcut() || daoFolderPointcut() || serviceFolderPointcut()")
    public void comboPointcut(){}
}
