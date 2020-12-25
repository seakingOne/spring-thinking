package com.ynhuang.thinking.beanDefinition;

import com.ynhuang.thinking.bean.UserInfo;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author YuHuang
 */
public class CreateBeanDefinitionDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserInfo.class)
                .addPropertyValue("id", 1)
                .addPropertyValue("name", "test1");

        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        applicationContext.registerBeanDefinition("user1", beanDefinition);

        applicationContext.refresh();

        System.out.println(applicationContext.getBean("user1", UserInfo.class));

        applicationContext.close();



    }

}
