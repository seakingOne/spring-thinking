package com.ynhuang.thinking.validated;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author YuHuang
 */
public class ValidateDemo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/user-validate.xml");

        applicationContext.refresh();

        UserProcess userProcess = applicationContext.getBean(UserProcess.class);
        userProcess.process(new UserValidate());

        applicationContext.close();

    }

    @Component
    @Validated
    static class UserProcess {

        public void process(@Valid UserValidate user) {
            System.out.println("user is :" + user);
        }

    }

    static class UserValidate {

        @NotNull(message = "{hello}")
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}

