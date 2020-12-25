package com.ynhuang.thinking.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author YuHuang
 */
public class ConditionalDemo {

    public static void main(String[] args) {

        System.out.println("main args is :" + args[0]);

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(ConditionalDemo.class);

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        environment.setActiveProfiles("one");

        applicationContext.refresh();

        Integer number = applicationContext.getBean("number", Integer.class);
        System.out.println("number is : " + number);

        applicationContext.close();

    }

    @Bean(name = "number")
    @Conditional(OneConditional.class)
    public Integer one() {
        return 1;
    }

}
