package com.kakuritsu.aopdemo.aspect;
import com.kakuritsu.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Order(1)
@Component
public class MyDemoLoggingAspect {
    // this is where we add all of our related advices for logging

    // let's start with a @Before advice



//    @Before("execution(public void com.kakuritsu.aopdemo.dao.AccountDAO.addAccount())")
//    @Before("execution(* com.kakuritsu.aopdemo.dao.*.*(..))")
    @Before("com.kakuritsu.aopdemo.aspect.AspectUtils.forDaoPackage()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println(methodSignature);
      Object[] args = theJoinPoint.getArgs();
      for(Object arg:args){
          if(arg instanceof Account){
              Account acc =(Account) arg;
              System.out.println(acc.getName());
          }
         else System.out.println(arg);
          }

      }
      @AfterThrowing
              (pointcut = "execution(* com.kakuritsu.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc"  )
      public void afterThrowingFindAccountsAdvice(Throwable theExc){
        System.out.println("THROABLE !!!" + theExc);
      }
      @After("execution(* com.kakuritsu.aopdemo.dao.AccountDAO.findAccounts(..))")
      public void afterFinallyFindAccountsAdvice(JoinPoint theJoinpoint){
        System.out.println(theJoinpoint.getSignature() + " IN @After FINALLY!");
      }
      @Around("execution(* com.kakuritsu.aopdemo.service.TrafficFortuneService.getFortune(..))")
      public Object aroundTrafficFortuneServiceGetFortuneAdvice(ProceedingJoinPoint theProceedingJointPoint) throws Throwable {
        Object theResult = null;
        try {
            long start = System.currentTimeMillis();
            theResult = theProceedingJointPoint.proceed();
            long end = System.currentTimeMillis();
            System.out.println("The total execution time of " + theProceedingJointPoint.getSignature() + " was " + (end - start) / 1000 + " Seconds");
        }
        catch(Exception exc){
           theResult = "Major exception here!";
           throw exc;
        }
        return theResult;
      };
    }


