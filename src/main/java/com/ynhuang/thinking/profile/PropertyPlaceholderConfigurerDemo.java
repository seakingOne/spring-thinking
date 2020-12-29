package com.ynhuang.thinking.profile;

import com.ynhuang.thinking.conversion.customer.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author YuHuang
 */
public class PropertyPlaceholderConfigurerDemo {

    @Value("${user.id}")
    private int id;

    @Value("${user.name}")
    private String name;

    public static void main(String[] args) {
        // 创建并且启动 Spring 应用上下文
        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/placeholders-resolver.xml");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(PropertyPlaceholderConfigurerDemo.class);

        User user = context.getBean("user", User.class);

        System.out.println(user);

        // 关闭 Spring 应用上下文
        context.close();
    }
}
