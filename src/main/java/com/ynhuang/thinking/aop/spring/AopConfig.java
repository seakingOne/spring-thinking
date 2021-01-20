package com.ynhuang.thinking.aop.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author YuHuang
 */
@Aspect
public class AopConfig {

    @Pointcut("execution(public * *(..))")
    private void pointCut() {

    }

    /**
     *
     * @param pjp
     * @throws Throwable
     */
    @Around("pointCut()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before...");
        pjp.proceed();
        System.out.println("around after...");
    }

    @Before("pointCut()")
    public void before() {
        System.out.println("all public method before...");
    }

}
