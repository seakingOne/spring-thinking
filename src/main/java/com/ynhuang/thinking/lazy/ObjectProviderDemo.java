package com.ynhuang.thinking.lazy;

import com.ynhuang.thinking.bean.UserInfo;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * @author YuHuang
 */
public class ObjectProviderDemo {

    @Autowired
    @Lazy
    private UserInfo userInfo;

    @Autowired
    private ObjectProvider<UserInfo> objectProvider;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(ObjectProviderDemo.class);

        applicationContext.refresh();

        ObjectProviderDemo bean = applicationContext.getBean(ObjectProviderDemo.class);
        System.out.println(bean.userInfo);
        System.out.println(bean.objectProvider.getObject());
        System.out.println(bean.objectProvider.getObject() == bean.userInfo);

        applicationContext.close();

    }

    @Bean
    public UserInfo userInfo() {

        UserInfo userInfo = new UserInfo();

        userInfo.setId(1);
        userInfo.setName("admin");

        return userInfo;
    }
}
