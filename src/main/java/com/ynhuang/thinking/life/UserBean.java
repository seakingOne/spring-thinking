package com.ynhuang.thinking.life;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author YuHuang
 */
public class UserBean implements InitializingBean {

    private int id;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("bean afterPropertiesSet");
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                '}';
    }
}
