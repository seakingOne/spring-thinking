package com.ynhuang.thinking.annotation.autowire;

import com.ynhuang.thinking.bean.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author YuHuang
 */
public class AutowireDemo {

    @Autowired
    private UserAnnotation userAnnotation;

    @Autowired
    private UserInfo userInfo;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(AutowireDemo.class);

        //applicationContext.addBeanFactoryPostProcessor(new MyBeanFactoryPostProcess());

        applicationContext.refresh();

        UserAnnotation userAnnotationData = getUserAnnotationData(applicationContext);

        System.out.println(userAnnotationData);

        //UserInfo user01 = applicationContext.getBean("user01", UserInfo.class);

        applicationContext.close();

    }

    @Bean
    public UserAnnotation userAnnotation() {

        UserAnnotation userAnnotation = new UserAnnotation();
        userAnnotation.setId(11);
        userAnnotation.setName("ynhuang");

        return userAnnotation;

    }

    @Bean
    public UserInfo userInfo() {

        UserInfo userInfo = new UserInfo();
        userInfo.setId(11);
        userInfo.setName("ynhuang-userinfo");

        return userInfo;

    }

    private static UserAnnotation getUserAnnotationData(AnnotationConfigApplicationContext applicationContext) {
        AutowireDemo bean = applicationContext.getBean(AutowireDemo.class);
        return bean.userAnnotation;
    }

}
