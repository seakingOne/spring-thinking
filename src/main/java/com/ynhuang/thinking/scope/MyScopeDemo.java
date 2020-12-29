package com.ynhuang.thinking.scope;

import com.ynhuang.thinking.conversion.customer.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;


/**
 * @author YuHuang
 */
public class MyScopeDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(MyScopeDemo.class);

        applicationContext.addBeanFactoryPostProcessor(new BeanFactoryPostProcessor() {
            @Override
            public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
                beanFactory.registerScope(MyThreadScope.SCOPE_NAME, new MyThreadScope());
            }
        });

        applicationContext.refresh();

        for (int i = 0; i < 3; i++) {

            new Thread(() -> {
                User bean = applicationContext.getBean(User.class);
                System.out.println(bean);
            }).start();

        }


        applicationContext.close();
    }

    @Bean
    @ThreadScope
    public User user() {
        User user = new User();

        user.setId(Integer.valueOf(String.valueOf(Thread.currentThread().getId())));
        user.setName("123");

        return user;
    }
}
