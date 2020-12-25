package com.ynhuang.thinking.conversion;

import org.springframework.core.convert.support.DefaultConversionService;

import java.util.Properties;

/**
 * @author YuHuang
 */
public class ConvertServiceDemo {

    public static void main(String[] args) {


        DefaultConversionService genericConversionService = new DefaultConversionService();

        Properties properties = new Properties();
        properties.put("key1", "value1");
        properties.put("key2", "value2");

        String convert = genericConversionService.convert(properties, String.class);


        String str = "key1=value1\nkey2=value2";
        Properties convert1 = genericConversionService.convert(str, Properties.class);

        System.out.println(convert);

        System.out.println(convert1);

    }
}
