package com.ynhuang.thinking.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author YuHuang
 */
public class I18nMain {

    public static void main(String[] args) {

        Locale aDefault = Locale.getDefault();

        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", aDefault);
        System.out.println(resourceBundle.getString("hello"));

    }
}
