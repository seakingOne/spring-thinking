package com.ynhuang.thinking.aop.spring;

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

    @Before("pointCut()")
    public void before() {
        System.out.println("all public method before...");
    }

}
