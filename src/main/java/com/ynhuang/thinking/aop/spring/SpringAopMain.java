package com.ynhuang.thinking.aop.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author YuHuang
 */
@EnableAspectJAutoProxy
public class SpringAopMain {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(SpringAopMain.class, AopConfig.class);

        applicationContext.refresh();
        SpringAopMain bean = applicationContext.getBean(SpringAopMain.class);
        bean.exec();
        applicationContext.close();
    }

    public void exec() {
        System.out.println("exec...");
    }
}
