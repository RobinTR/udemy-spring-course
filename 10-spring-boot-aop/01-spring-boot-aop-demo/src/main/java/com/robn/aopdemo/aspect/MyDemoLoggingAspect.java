package com.robn.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // This is where we add all of our related advices for logging

    // Let's start with @Before advice
    /*
    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n======>>> Executing @Before advice on addAccount()");
    }
     */
    /*
    @Before("execution(public void com.robn.aopdemo.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n======>>> Executing @Before advice on addAccount()");
    }
     */
    //@Before("execution(public void add*())")
    //@Before("execution(void add*())")
    @Before("execution(* add*())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n======>>> Executing @Before advice on add*()");
    }
}
