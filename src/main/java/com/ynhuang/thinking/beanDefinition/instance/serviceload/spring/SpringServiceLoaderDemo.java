package com.ynhuang.thinking.beanDefinition.instance.serviceload.spring;

import com.ynhuang.thinking.beanDefinition.instance.serviceload.jdk.MyServiceLoaderInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author YuHuang
 */
public class SpringServiceLoaderDemo {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/services/serviceloader.xml");

        ServiceLoader<MyServiceLoaderInterface> bean = applicationContext.getBean("serviceLoaderFactoryBean", ServiceLoader.class);

        Iterator<MyServiceLoaderInterface> iterator = bean.iterator();
        while (iterator.hasNext()) {
            MyServiceLoaderInterface next = iterator.next();
            System.out.println(next.sayHello());
        }

    }
}
