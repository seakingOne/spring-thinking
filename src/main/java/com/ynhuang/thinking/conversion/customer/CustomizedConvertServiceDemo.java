package com.ynhuang.thinking.conversion.customer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author YuHuang
 */
public class CustomizedConvertServiceDemo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/convert/convert.xml");


        User bean = applicationContext.getBean(User.class);
        System.out.println(bean);

    }
}
