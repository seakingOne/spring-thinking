package com.ynhuang.thinking.yaml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.Map;

/**
 * @author YuHuang
 */
public class YamlMapFactoryBeanDemo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/user-info-yaml.xml");

        applicationContext.refresh();

        Map<String, Object> map = applicationContext.getBean("yamlMap", Map.class);
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Object> next = iterator.next();
            System.out.println(next.getKey() + ", " + next.getValue());
        }

        applicationContext.close();


    }

}
