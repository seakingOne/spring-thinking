package com.ynhuang.thinking.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.ObjectUtils;

/**
 * @author YuHuang
 */
public class LifeDemo {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LifeDemo{" +
                "id=" + id +
                '}';
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();

        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        applicationContext.register(LifeDemo.class);

        applicationContext.refresh();

        LifeDemo bean = applicationContext.getBean(LifeDemo.class);
        System.out.println(bean);

        applicationContext.close();

//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/user-info-yaml.xml");
//
//        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
//        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
//
//        applicationContext.refresh();
//
//        Object userBean = applicationContext.getBean("userBean");
//        System.out.println(userBean);

    }

    static class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

        @Override
        public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {

            if (ObjectUtils.nullSafeEquals(beanName, "lifeDemo") && beanClass.equals(LifeDemo.class)) {

                LifeDemo lifeDemo = new LifeDemo();
                lifeDemo.setId(12);

                return lifeDemo;
            }

            return null;
        }

    }

}


