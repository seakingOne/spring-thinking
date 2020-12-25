package com.ynhuang.thinking.beanDefinition.instance.beanfactory;

import com.ynhuang.thinking.bean.UserInfo;

public class MyBeanFactory {

    public static UserInfo createUser() {

        UserInfo info = new UserInfo();
        info.setId(1);
        info.setName("name1");

        return info;
    }

}
