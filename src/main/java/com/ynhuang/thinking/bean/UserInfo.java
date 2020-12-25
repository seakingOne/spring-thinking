package com.ynhuang.thinking.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
public class UserInfo implements InitializingBean {

    private int id;

    private String name;

    private int age;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("111111");
    }
}
