package com.ynhuang.thinking.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author YuHuang
 */
@ComponentScan("com.ynhuang.thinking.annotation")
public class AnnotationDemo {

    @Value("${my.name:test11}")
    private String name;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();


        applicationContext.register(AnnotationDemo.class);

        applicationContext.refresh();
        Test bean = applicationContext.getBean(Test.class);
        System.err.println(bean);


        AnnotationDemo bean1 = applicationContext.getBean(AnnotationDemo.class);
        System.out.println(bean1.name);

        applicationContext.close();

    }
}
