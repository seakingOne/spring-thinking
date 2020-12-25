package com.ynhuang.thinking.conversion;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

/**
 * @author YuHuang
 *
 * {@link PropertyEditor} Java自带的类型转换, 局限点: 只能在String层面操作
 *
 */
public class StringConversionToProperty extends PropertyEditorSupport {

    public static void main(String[] args) {
        StringConversionToProperty propertyConversionToString = new StringConversionToProperty();
        String text = "name=ynhuang";

        propertyConversionToString.setAsText(text);

        System.out.println(propertyConversionToString.getValue() instanceof Properties);
    }

    /**
     * 将String类型转换为目标对象类型
     * @param text
     * @throws IllegalArgumentException
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        Properties properties = new Properties();

        try {
            properties.load(new StringReader(text));
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }

        setValue(properties);

    }

    @Override
    public String getAsText() {
        return super.getAsText();
    }
}
