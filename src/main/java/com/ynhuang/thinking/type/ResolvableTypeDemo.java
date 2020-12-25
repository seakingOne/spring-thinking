package com.ynhuang.thinking.type;

import org.springframework.core.ResolvableType;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * {@link ResolvableType}
 *
 * @author YuHuang
 */
public class ResolvableTypeDemo {

    public static void main(String[] args) {

        ResolvableType resolvableType = ResolvableType.forClass(MyList.class);
        Type type = resolvableType.getType();
        System.out.println(type.getTypeName());

    }

    static class MyList extends ArrayList<String> {

    }
}
