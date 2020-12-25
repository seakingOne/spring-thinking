package com.ynhuang.thinking.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

import static org.springframework.context.support.AbstractApplicationContext.MESSAGE_SOURCE_BEAN_NAME;

/**
 * @author YuHuang
 */
@Configuration
public class MessageResourceDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(MessageResourceDemo.class);

        applicationContext.refresh();

        MessageSource messageSource = applicationContext.getBean(MESSAGE_SOURCE_BEAN_NAME, MessageSource.class);
        String hello = messageSource.getMessage("hello", new Object[]{}, Locale.CHINA);

        System.out.println(hello);

        applicationContext.close();

    }

    @Bean(name = MESSAGE_SOURCE_BEAN_NAME)
    public MessageSource messageSource() {

        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();

        resourceBundleMessageSource.setBasenames("messages", "2222");
        resourceBundleMessageSource.setDefaultEncoding("UTF-8");


        return resourceBundleMessageSource;

    }

    @Bean
    public SessionLocaleResolver sessionLocaleResolver(){

        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.CHINA);

        return sessionLocaleResolver;
    }
}
