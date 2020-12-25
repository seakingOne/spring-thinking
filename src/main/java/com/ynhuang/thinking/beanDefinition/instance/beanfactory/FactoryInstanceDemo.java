package com.ynhuang.thinking.beanDefinition.instance.beanfactory;

import com.ynhuang.thinking.bean.UserInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author YuHuang
 */
public class FactoryInstanceDemo {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/beanfacory/user-info-by-beanfactory.xml");
        System.out.println(applicationContext.getBean(UserInfo.class));

    }



}

