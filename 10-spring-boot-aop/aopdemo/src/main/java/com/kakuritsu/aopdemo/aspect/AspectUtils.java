package com.kakuritsu.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectUtils {
    @Pointcut("execution(* com.kakuritsu.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){};
    @Pointcut("execution(* com.kakuritsu.aopdemo.dao.*.get*(..))")
    public void getter(){};
    @Pointcut("execution(* com.kakuritsu.aopdemo.dao.*.set*(..))")
    public void setter(){};
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){};
    @Pointcut("execution(java.util.List<com.kakuritsu.aopdemo.Account> com.kakuritsu.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void forAccountDAOfindAllAccounts(){}
}
