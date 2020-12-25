package com.ynhuang.nacos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/nacos")
public class TestController {

    @Resource
    private NacosConfigurationPropertiesConfiguration configurationPropertiesConfiguration;

    @GetMapping(value = "/name")
    public String getNacos() {
        return configurationPropertiesConfiguration.getName();
    }

}
