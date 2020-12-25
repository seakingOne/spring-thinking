package com.ynhuang.thinking.inject;

import com.ynhuang.thinking.bean.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

import javax.annotation.PostConstruct;

/**
 * @author YuHuang
 */
public class InjectDemo {

    @Autowired
    private UserInfo userInfo;

    @PostConstruct
    public void postUserInfo() {
        System.out.println("post....");
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        beanDefinitionReader.loadBeanDefinitions("META-INF/my-xml.xml");

        applicationContext.register(InjectDemo.class);

        applicationContext.refresh();

        InjectDemo injectDemo = applicationContext.getBean(InjectDemo.class);
        System.out.println(injectDemo.userInfo);

        UserInfo userInfo = applicationContext.getBean("getUserInfo", UserInfo.class);
        System.out.println(userInfo);

        applicationContext.close();


        ConversionService conversionService = new DefaultConversionService();
        Integer integer = conversionService.convert("1", Integer.class);
        System.out.println(integer);

    }

    @Bean
    public UserInfo getUserInfo() {

        UserInfo userInfo = new UserInfo();
        userInfo.setName("newTest");

        System.out.println("bean....");

        return userInfo;
    }

}
