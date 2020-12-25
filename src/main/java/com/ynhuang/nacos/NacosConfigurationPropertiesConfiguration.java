package com.ynhuang.nacos;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;


/**
 * @author YuHuang
 */
@Configuration
@EnableNacosConfig()
@NacosPropertySource(dataId = "test", groupId = "DEFAULT_GROUP", autoRefreshed = true)
@Slf4j
public class NacosConfigurationPropertiesConfiguration {

    @NacosValue(value = "${name}", autoRefreshed = true)
    private String name;

    @PostConstruct
    public void init() {
        log.error("name is : {}", name);
    }

    public String getName() {
        return name;
    }

}
