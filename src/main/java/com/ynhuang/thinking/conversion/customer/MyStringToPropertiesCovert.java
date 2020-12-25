package com.ynhuang.thinking.conversion.customer;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Properties;
import java.util.Set;

/**
 * @author YuHuang
 */
public class MyStringToPropertiesCovert implements ConditionalGenericConverter {

    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        return String.class.equals(sourceType.getObjectType())
                && Properties.class.equals(targetType.getObjectType());
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(String.class, Properties.class));
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {

        System.out.println("进入我自定义的convert");

        String str = (String) source;
        Properties properties = new Properties();
        try {
            properties.load(new ByteArrayInputStream(str.getBytes(StandardCharsets.ISO_8859_1)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }

}
