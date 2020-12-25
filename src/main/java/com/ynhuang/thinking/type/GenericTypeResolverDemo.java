package com.ynhuang.thinking.type;


import org.springframework.core.GenericTypeResolver;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * {@link GenericTypeResolver}
 *
 * @author YuHuang
 */
public class GenericTypeResolverDemo {

    public static void main(String[] args) throws NoSuchMethodException {

        Method method = GenericTypeResolverDemo.class.getMethod("getString");
        Class<?> returnType = GenericTypeResolver.resolveReturnType(method, GenericTypeResolverDemo.class);
        System.out.println(returnType);

        Method listMethod = GenericTypeResolverDemo.class.getMethod("getList");
        Class<?> returnType1 = GenericTypeResolver.resolveReturnType(listMethod, GenericTypeResolverDemo.class);
        System.out.println(returnType1);


        Method method1 = GenericTypeResolverDemo.class.getMethod("getMyList");
        Class<?> aClass = GenericTypeResolver.resolveReturnTypeArgument(method1, List.class);
        System.out.println(aClass);

        System.out.println("---------------------------");
        Map<TypeVariable, Type> typeVariableMap = GenericTypeResolver.getTypeVariableMap(MyList.class);
        typeVariableMap.entrySet().forEach(x -> System.out.println(x.getKey() + ", " + x.getValue()));

    }


    public static MyList getMyList() {
        return null;
    }

    public static String getString() {
        return null;
    }

    public static <E> List<E> getList() {
        return null;
    }

    static class MyList extends ArrayList<String> {

    }

}
