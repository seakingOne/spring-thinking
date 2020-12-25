package com.ynhuang.thinking.myXmlTag;

import com.ynhuang.thinking.bean.UserInfo;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author YuHuang
 */
public class MyXmlTagDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        int countBean = xmlBeanDefinitionReader.loadBeanDefinitions("classpath:/META-INF/my-xml.xml");
        System.out.println(countBean);
        UserInfo userInfo = beanFactory.getBean(UserInfo.class);
        System.out.println(userInfo);

    }
}
