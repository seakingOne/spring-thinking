package com.ynhuang.thinking.yaml;

import com.ynhuang.thinking.bean.UserInfo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

/**
 * @author YuHuang
 */
@PropertySource(name = "yamlPropertySource",
                value = "classpath:/META-INF/userinfo.yaml",
                factory = YamlPropertySourceFactory.class)
public class YamlPropertyFactoryBeanDemo {

    @Bean
    public UserInfo getUserInfo(@Value("${user.id}") int id, @Value("${user.name}") String name, @Value("${user.age}") int age) {
        UserInfo userInfo = new UserInfo();

        userInfo.setId(id);
        userInfo.setName(name);
        userInfo.setAge(age);

        return userInfo;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(YamlPropertyFactoryBeanDemo.class);

        applicationContext.refresh();

        UserInfo userInfo = applicationContext.getBean(UserInfo.class);
        System.out.println(userInfo);

        applicationContext.close();
    }

}
