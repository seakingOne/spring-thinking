package com.ynhuang.thinking.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author YuHuang
 */
public class ProfileDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(ProfileDemo.class);

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        environment.setActiveProfiles("twoProfile");

        applicationContext.refresh();

        Integer number = applicationContext.getBean("number", Integer.class);
        System.out.println("number is : " + number);

        applicationContext.close();
    }

    @Bean(name = "number")
    @Profile("twoProfile")
    public Integer two() {
        return 2;
    }

}
