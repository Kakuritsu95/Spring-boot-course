package com.kakuritsu.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AspectUtils {

    @Pointcut("execution(* com.kakuritsu.springboot.thymeleafdemo.controller.*.*(..))")
    public void controllerFolderPointCut(){}
    @Pointcut("execution(* com.kakuritsu.springboot.thymeleafdemo.dao.*.*(..))")
    public void daoFolderPointCut(){}
    @Pointcut("execution(* com.kakuritsu.springboot.thymeleafdemo.service.*.*(..))")
    public void serviceFolderPointCut(){}
}
