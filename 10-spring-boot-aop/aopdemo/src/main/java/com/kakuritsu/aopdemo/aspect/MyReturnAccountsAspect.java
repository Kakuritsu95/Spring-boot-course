package com.kakuritsu.aopdemo.aspect;

import com.kakuritsu.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AdviceName;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Order(-1)
@Component
public class MyReturnAccountsAspect {

    @AfterReturning(pointcut = "com.kakuritsu.aopdemo.aspect.AspectUtils.forAccountDAOfindAllAccounts()", returning = "result" )
    public void afterReturningAllAccounts(JoinPoint theJoinPoint, List<Account> result){
        System.out.println(theJoinPoint.getThis());
        System.out.println(result + "Modifying the result before returning");
        if (!result.isEmpty()) {
          Account tempAccount = result.getFirst();
          tempAccount.setName("FILETH!");
        }
    }
}
