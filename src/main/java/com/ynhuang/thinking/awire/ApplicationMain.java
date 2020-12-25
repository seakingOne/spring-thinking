package com.ynhuang.thinking.awire;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class ApplicationMain implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationMain.applicationContext = applicationContext;
    }

    public static void checkApplicationContext() {
        Assert.notNull(applicationContext,
                "ApplicationContext is invalid.");
    }

}
